package com.example.testcivitatis.datasource.remotedatasource

import com.example.testcivitatis.repository.remotetypes.JobPosting
import retrofit2.Call
import retrofit2.http.GET
import java.util.concurrent.Flow

interface GetJobPostingsApi {
    @GET("positions.json") fun getJobPostings(): Call<List<JobPosting>>

}