package com.hegunhee.wirebarleytest.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.wirebarleytest.model.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository : Repository): ViewModel() {

    fun initData() {
        viewModelScope.launch {
            Log.d("body", repository.getResponseBody().body().toString())

        }

    }


}