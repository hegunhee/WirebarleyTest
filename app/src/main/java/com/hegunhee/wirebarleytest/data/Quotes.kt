package com.hegunhee.wirebarleytest.data


import com.google.gson.annotations.SerializedName

data class Quotes(
    @SerializedName("USDKRW")
    val USDKRW: Double,
    @SerializedName("USDJPY")
    val USDJPY: Double,
    @SerializedName("USDPHP")
    val USDPHP: Double
)