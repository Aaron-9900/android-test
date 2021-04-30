package com.example.testcivitatis.repository.remotetypes

import com.example.testcivitatis.repository.localtypes.JobPosting
import com.example.testcivitatis.utils.toFormattedDate
import com.google.gson.annotations.SerializedName
import java.util.*

data class JobPosting (
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("company_logo")
    val companyLogo: String?,
    @SerializedName("location")
    val location: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String
) {
    fun toDomain(): com.example.testcivitatis.repository.localtypes.JobPosting {
        return JobPosting(id, type, url, title, company, companyLogo, location,
            createdAt.toFormattedDate("EEE MMM dd HH:mm:ss zzz yyyy"), description)
    }
}