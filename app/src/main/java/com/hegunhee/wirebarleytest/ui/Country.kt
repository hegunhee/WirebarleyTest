package com.hegunhee.wirebarleytest.ui

import com.hegunhee.wirebarleytest.data.Quotes

sealed class Country{
    object Korea : Country()
    object Japan : Country()
    object Philippines : Country()

    fun toEnglish() : String= when(this){
        Japan -> "JPY"
        Korea -> "KRW"
        Philippines -> "PHP"
    }
    fun toKorea() : String = when(this){
        Japan -> "일본"
        Korea -> "한국"
        Philippines -> "필리핀"
    }

    fun toRate(quotes : Quotes) : Double = when(this){
        Korea -> quotes.USDKRW
        Japan -> quotes.USDJPY
        Philippines -> quotes.USDPHP
    }
}
