package com.example.testcivitatis.modules

import com.example.testcivitatis.repository.JobPostingsRepository
import com.example.testcivitatis.repository.JobPostingsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<JobPostingsRepository> { JobPostingsRepositoryImpl(get()) }
}