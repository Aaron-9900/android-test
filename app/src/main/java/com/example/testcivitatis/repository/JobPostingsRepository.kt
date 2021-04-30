package com.example.testcivitatis.repository

import com.example.testcivitatis.repository.localtypes.JobPosting
import kotlinx.coroutines.flow.Flow

interface JobPostingsRepository {
    suspend fun getJobPostings(): Flow<List<JobPosting>>
}