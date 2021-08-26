package com.varsha.greedygameassignment.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.varsha.greedygameassignment.R
import com.varsha.greedygameassignment.data.local.SaveNewsEntity
import com.varsha.greedygameassignment.views.adapter.SaveNewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_save.*

class SaveActivity : AppCompatActivity() {
    private val newsEntity = mutableListOf<SaveNewsEntity>()

    lateinit var newsAdapter: SaveNewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        val app = application as ApplicationClass
        newsAdapter = SaveNewsAdapter( this@SaveActivity,newsEntity)
        recyclerView_save.layoutManager = LinearLayoutManager(this)
        recyclerView_save.adapter = newsAdapter
        app.saveNewsDao.getSaveNews().observe(this, Observer {
            newsEntity.clear()
            newsEntity.addAll(it)
            newsAdapter.notifyDataSetChanged()
        })
    }


}