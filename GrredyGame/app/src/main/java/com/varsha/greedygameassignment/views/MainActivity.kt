package com.varsha.greedygameassignment.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.varsha.greedygameassignment.R
import com.varsha.greedygameassignment.data.local.NewsEntity
import com.varsha.greedygameassignment.viewmodels.NewsViewModel
import com.varsha.greedygameassignment.viewmodels.NewsViewModelFactory
import com.varsha.greedygameassignment.views.adapter.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    private val newsEntity = mutableListOf<NewsEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        save_button_activity.setOnClickListener {
            startActivity(Intent(this@MainActivity,SaveActivity::class.java))
        }
        newsAdapter = NewsAdapter(this@MainActivity, newsEntity)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter
        val app = application as ApplicationClass
        val newsViewModelFactory = NewsViewModelFactory(app.repository)
        newsViewModel = ViewModelProviders.of(this, newsViewModelFactory)
            .get(NewsViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            if (newsViewModel.getCount() == 0)
                newsViewModel.insertNews()
        }
        newsViewModel.getNews().observe(this, Observer {
            newsEntity.clear()
            newsEntity.addAll(it)
            newsAdapter.notifyDataSetChanged()
        })

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchDatabase(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    /**
     * A function for search related query from database.
     */
    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"
        newsViewModel.searchDatabase(searchQuery).observe(this, { list ->
            list.let {
                newsAdapter.setData(it)
            }
        })
    }


}