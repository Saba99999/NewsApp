package com.example.newsapp.repository

import androidx.room.Query
import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.moduls.Article

class NewsRepository(
    val  db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode : String,pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun serchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun delateArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}