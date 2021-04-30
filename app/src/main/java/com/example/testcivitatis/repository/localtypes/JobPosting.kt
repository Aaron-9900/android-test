package com.example.testcivitatis.repository.localtypes

import android.provider.Settings.Global.getString
import com.example.testcivitatis.R
import java.io.Serializable
import java.util.*


data class JobPosting (
    val id: String,
    val type: String,
    val url: String,
    val title: String,
    val company: String,
    val companyLogo: String?,
    val location: String,
    val createdAt: Date,
    val description: String
    ): Serializable