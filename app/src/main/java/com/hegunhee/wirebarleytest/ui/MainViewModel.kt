package com.hegunhee.wirebarleytest.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.wirebarleytest.data.Quotes
import com.hegunhee.wirebarleytest.model.Repository
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainViewModel(private val repository: Repository) : ViewModel() {

    private var _countryText = MutableLiveData<String>("")
    val countryText: LiveData<String>
        get() = _countryText

    private var _rateText = MutableLiveData<String>("")
    val rateText: LiveData<String>
        get() = _rateText

    private var _time = MutableLiveData<String>("")
    val time: LiveData<String>
        get() = _time

    private var _changedMoney = MutableLiveData<String>("")
    val changedMoney: LiveData<String>
        get() = _changedMoney

    val switch = MutableLiveData<Switch>(Switch.Uninitalized)

    var country: Country = Country.Korea

    var countryKoreaName = "한국"
    var countryEnglishName = "KRW"

    var currentRate: Double = 0.0
    var dollers: Int = 0

    lateinit var storedQuotes: Quotes

    private var _totalValueVisible = MutableLiveData<Boolean>(false)
    val totalValueVisible: LiveData<Boolean>
        get() = _totalValueVisible

    fun initData() {
        changeData()
    }


    fun onClickSendCountry() = viewModelScope.launch {
        switch.postValue(Switch.Clicked)
    }

    fun changeData() {
        viewModelScope.launch {
            repository.getResponse().body()?.run {
                if (success) {
                    storedQuotes = quotes
                    currentRate = country.toRate(quotes)
                } else {
                    currentRate = country.toRate(storedQuotes)
                }
            }
            countryKoreaName = country.toKorea()
            countryEnglishName = country.toEnglish()
            _countryText.value = "$countryKoreaName ($countryEnglishName)"
            _rateText.value = "${currentRate.changeFormat()} $countryEnglishName / USD"
            _time.value = getCurrentTime()
            setSendingMoney()
        }
    }

    private fun setSendingMoney() {
        _changedMoney.value = "수취 금액은 ${(currentRate * dollers).changeFormat()} $countryEnglishName 입니다."
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s.length >= 7) {
            return
        }
        if (s.isEmpty()) {
            if (totalValueVisible.value == true) _totalValueVisible.value = false
        } else {
            if (isPossibleRange(s.toString().toInt())) {
                if (totalValueVisible.value == false) _totalValueVisible.value = true
                dollers = s.toString().toInt()
                setSendingMoney()
            } else {
                if (totalValueVisible.value == true) _totalValueVisible.value = false
            }
        }
    }

    private fun isPossibleRange(text: Int): Boolean {
        return if (text <= 0 || text.toString().isEmpty()) {
            false
        } else text <= 10000
    }

    private fun getCurrentTime(): String {
        val current = LocalDateTime.now().plusHours(9)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        return current.format(formatter)
    }

    private fun Double.changeFormat(): String {
        DecimalFormat("#,###.00").run {
            return format(this@changeFormat)
        }
    }
}