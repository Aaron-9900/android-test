package com.example.testcivitatis.modules
import com.example.testcivitatis.datasource.remotedatasource.GetJobPostings
import com.example.testcivitatis.datasource.remotedatasource.GetJobPostingsImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<GetJobPostings> { GetJobPostingsImpl(get()) }
}