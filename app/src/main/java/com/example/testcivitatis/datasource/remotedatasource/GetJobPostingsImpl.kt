package com.example.testcivitatis.datasource.remotedatasource

import com.example.testcivitatis.repository.localtypes.JobPosting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetJobPostingsImpl(private val jobPostingsApi: GetJobPostingsApi): GetJobPostings {
    override suspend fun getJobPostings(): Flow<List<JobPosting>> = flow {
        var response = jobPostingsApi.getJobPostings().execute()
        if (!response.isSuccessful) {
            throw Exception("NetworkCall error")
        }
        response.body()?.let {
            emit(it.map { jobPosting -> jobPosting.toDomain() })
        }
    }
}

