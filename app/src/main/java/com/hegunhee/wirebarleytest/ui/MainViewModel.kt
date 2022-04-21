package com.hegunhee.wirebarleytest.ui

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.wirebarleytest.model.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository : Repository): ViewModel() {

    private var _country = MutableLiveData<Country>(Country.Korea)
    val country : LiveData<Country>
    get() = _country

    private var _countryText = MutableLiveData<String>("한국")
    val countryText : LiveData<String>
    get() = _countryText

    private var _currentRate = MutableLiveData<Double>()
    val currentRate : LiveData<Double>
    get() = _currentRate

    private var _usdValue = MutableLiveData<Int>(0)
    val usdValue : LiveData<Int>
    get() = _usdValue

    var dollers : Int = 0

    private var _totalValueVisible = MutableLiveData<Boolean>(false)
    val totalValueVisible : LiveData<Boolean>
    get() = _totalValueVisible
    fun initData() {
        viewModelScope.launch {
            Log.d("body", repository.getResponse().body().toString())
        }


    }

    private fun isPossibleRange(text : Int) : Boolean {
        return if(text <= 0 || text.toString().isEmpty()){
            Log.d("possible","text <= 0 or length >=5 false")
            false
        }else if(text <= 10000){
            Log.d("possible","true possible")
            true
        }else{
            Log.d("possible","text > 10000 or length >=5 false")
            false
        }
    }
    fun onTextChanged(s : CharSequence, start : Int,before : Int, count : Int){
        if(s.isEmpty()){
            if(totalValueVisible.value == true) _totalValueVisible.value = false
        }else{
            if(isPossibleRange(s.toString().toInt())){
                if(totalValueVisible.value == false) _totalValueVisible.value = true
                dollers = s.toString().toInt()
                Log.d("possible",dollers.toString())
            }else{
                if(totalValueVisible.value == true) _totalValueVisible.value = false
            }
        }
    }

}