package com.varsha.greedygameassignment.views.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.varsha.greedygameassignment.R
import com.varsha.greedygameassignment.data.local.NewsEntity
import com.varsha.greedygameassignment.data.local.SaveNewsDatabase
import com.varsha.greedygameassignment.data.local.SaveNewsEntity
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This class is responsible for create and bind the data in the recyclerview
 */
class NewsAdapter(

    val context: Context,
    private var newsList: List<NewsEntity>
) : RecyclerView.Adapter<NewsAdapter.PostViewHolder>() {

    private val saveNewsDao by lazy {
        val roomDatabase= SaveNewsDatabase.getSaveNewsDatabase(context)
        roomDatabase.getMySaveNewsDao()
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return PostViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.apply {
           Glide.with(context).load(newsList[position].image).placeholder(R.drawable.placeholder_image).into(image_news)
            text_news_title.text = newsList[position].title
            text_news_description.text = newsList[position].description+"..."
            text_date.text=newsList[position].date
            button_save.setOnClickListener {
                val saveNewsEntity=SaveNewsEntity(
                    newsList[position].image,
                    "Politics",newsList[position].title,
                    newsList[position].date,
                    "Varsha"
                )
                insertSaveNews(saveNewsEntity)
            }
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
    private fun insertSaveNews(saveNewsEntity: SaveNewsEntity) {

        CoroutineScope(Dispatchers.IO).launch {
            saveNewsDao.insertSaveNews(saveNewsEntity)
        }
    }
    fun setData(newData: List<NewsEntity>) {
        newsList = newData
        notifyDataSetChanged()
    }

}