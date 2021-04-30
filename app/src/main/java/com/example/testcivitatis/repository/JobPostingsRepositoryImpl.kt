package com.example.testcivitatis.repository

import com.example.testcivitatis.datasource.remotedatasource.GetJobPostings
import com.example.testcivitatis.repository.localtypes.JobPosting
import kotlinx.coroutines.flow.Flow

class JobPostingsRepositoryImpl(private val jobPostingsRemote: GetJobPostings): JobPostingsRepository {
    override suspend fun getJobPostings(): Flow<List<JobPosting>> {
        return jobPostingsRemote.getJobPostings()
    }
}