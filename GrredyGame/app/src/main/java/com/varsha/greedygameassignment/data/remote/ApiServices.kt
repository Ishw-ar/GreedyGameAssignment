package com.varsha.greedygameassignment.data.remote

import com.varsha.greedygameassignment.data.models.LatestNewsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL="https://newsapi.org/"
const val API_KEY="0b43be1f3dc84b2492d6691164b3edac"

/**
 * The getPost method will return the Response which we are getting from Api
 */
interface ApiInterface{

    @GET("v2/top-headlines")
     suspend fun getLatestNews(
        @Query("country")
        countryCode: String = "us",
        @Query("apiKey")
        apiKey: String = API_KEY
     ) : LatestNewsResponse
}

/**
 * The ApiServices class is responsible for making the api call by using Retrofit
 */
object ApiServices {
    val instance:ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        instance = retrofit.create(ApiInterface::class.java)

    }
}