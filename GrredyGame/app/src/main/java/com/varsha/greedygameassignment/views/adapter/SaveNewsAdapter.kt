package com.varsha.greedygameassignment.views.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.varsha.greedygameassignment.R
import com.varsha.greedygameassignment.data.local.SaveNewsEntity
import kotlinx.android.synthetic.main.save_news_item.view.*

/**
 * This class is responsible for create and bind the data in the recyclerview
 */
class SaveNewsAdapter(
    val context: Context,
    private var saveNewsList: List<SaveNewsEntity>
) : RecyclerView.Adapter<SaveNewsAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.save_news_item, parent, false)
        return PostViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(context).load(saveNewsList[position].image).into(save_news_image)
            protest.text=saveNewsList[position].hashtag
            save_text.text=saveNewsList[position].title
            save_date.text=saveNewsList[position].date
        }
    }

    override fun getItemCount(): Int {
        return saveNewsList.size
    }


}