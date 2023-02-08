package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {


//    lateinit var viewModel: NewsViewModel
    private lateinit var navController : NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        navController = this.findNavController(R.id.newsNavHostFragment)
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{_,destination,_->
            when (destination.id){
                R.id.breakingNewsFragment-> bottomNavigationView.isVisible = true
                R.id.searchNewsFragments -> bottomNavigationView.isVisible= true
                R.id.savedNewsFragments -> bottomNavigationView.isVisible = true
                else -> bottomNavigationView.isVisible = false
            }
        }

        val newsRepository = NewsRepository(ArticleDatabase(this))
//        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
//        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
//       bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}