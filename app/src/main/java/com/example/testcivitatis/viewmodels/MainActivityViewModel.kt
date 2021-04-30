package com.example.testcivitatis.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testcivitatis.repository.JobPostingsRepositoryImpl
import com.example.testcivitatis.repository.localtypes.JobPosting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivityViewModel(private val jobPostingsRepository: JobPostingsRepositoryImpl): BaseViewModel() {

    private val mutablePostings = MutableLiveData<List<JobPosting>>()
    val postings: LiveData<List<JobPosting>>
        get() = mutablePostings

    fun fetchJobPostings() {
        setViewState(ViewModelState.PENDING)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    jobPostingsRepository.getJobPostings()
                        .collect {
                            mutablePostings.postValue(it)
                            setViewState(ViewModelState.DONE)
                        }
                } catch(err: Exception) {
                    Log.e("CALL ERROR", "Network error", err)
                    setViewState(ViewModelState.ERROR)
                }

            }
        }
    }
}