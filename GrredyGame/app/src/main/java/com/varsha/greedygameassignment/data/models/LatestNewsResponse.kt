package com.varsha.greedygameassignment.data.models


import com.google.gson.annotations.SerializedName

data class LatestNewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)