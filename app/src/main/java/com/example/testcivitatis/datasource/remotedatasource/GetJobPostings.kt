package com.example.testcivitatis.datasource.remotedatasource

import com.example.testcivitatis.repository.localtypes.JobPosting
import kotlinx.coroutines.flow.Flow

interface GetJobPostings {
    suspend fun getJobPostings(): Flow<List<JobPosting>>
}