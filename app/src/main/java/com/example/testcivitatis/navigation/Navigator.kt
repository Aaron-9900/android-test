package com.example.testcivitatis.navigation

import com.example.testcivitatis.repository.localtypes.JobPosting

interface Navigator {
    fun goToDetail(posting: JobPosting)
    fun goToWebView(url: String)
}