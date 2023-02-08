package com.example.newsapp.moduls

import com.example.newsapp.moduls.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)