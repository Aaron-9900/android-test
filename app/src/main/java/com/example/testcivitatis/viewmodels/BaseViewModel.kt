package com.example.testcivitatis.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcivitatis.viewmodels.ViewModelState

open class BaseViewModel: ViewModel() {
    private val mutableStatus = MutableLiveData<ViewModelState>()
    open val status: LiveData<ViewModelState>
    get() = mutableStatus
    init {
        mutableStatus.postValue(ViewModelState.IDLE)
    }

    fun setViewState(state: ViewModelState) {
        mutableStatus.postValue(state)
    }
}