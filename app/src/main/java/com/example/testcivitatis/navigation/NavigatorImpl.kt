package com.example.testcivitatis.navigation

import android.content.Context
import android.content.Intent
import com.example.testcivitatis.activities.DetailActivity
import com.example.testcivitatis.activities.WebView
import com.example.testcivitatis.repository.localtypes.JobPosting

class NavigatorImpl(private val context: Context) : Navigator {
    override fun goToDetail(posting: JobPosting) {
      context.apply {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("JOB_POSTING", posting)
            startActivity(intent)
        }
    }

    override fun goToWebView(url: String) {
        context.apply {
            val intent = Intent(this, WebView::class.java)
            intent.putExtra("URL", url)
            startActivity(intent)
        }
    }
}