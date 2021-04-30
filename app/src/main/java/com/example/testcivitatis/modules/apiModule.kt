package com.example.testcivitatis.modules

import com.example.testcivitatis.datasource.remotedatasource.ApiConstants
import com.example.testcivitatis.datasource.remotedatasource.GetJobPostingsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

        single {
            okHttp()
        }
        single {
            retrofit(ApiConstants.BASE_URL)
        }
        single {
            get<Retrofit>().create(GetJobPostingsApi::class.java)
        }
}
private fun okHttp() = OkHttpClient.Builder()
    .build()
private fun retrofit(baseUrl: String) = Retrofit.Builder()
    .callFactory(OkHttpClient.Builder().build())
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()