package com.varsha.greedygameassignment.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.varsha.greedygameassignment.R
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        if (intent.extras!=null){
            Glide.with(this).load(intent.getStringExtra("image")).into(image_details)
            show_text_details.text=intent.getStringExtra("title")
            shows_description_details.text=intent.getStringExtra("description")
            show_date_details.text=intent.getStringExtra("date")
            tvName_details.text=intent.getStringExtra("author")
            tvCompanyName_details.text=intent.getStringExtra("companyname")
            Glide.with(this).load(intent.getStringExtra("image")).into(save_news_image_details)

            btn_back_details.setOnClickListener {
                val intent =Intent(this@NewsDetailsActivity,MainActivity::class.java)
                startActivity(intent)
            }
            image_save_details.setOnClickListener {
                val intent =Intent(this@NewsDetailsActivity,SaveActivity::class.java)
                startActivity(intent)
            }


        }

    }
}