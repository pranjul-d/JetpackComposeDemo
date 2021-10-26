package com.softradix.jetpackcomposedemo.data


import com.google.gson.annotations.SerializedName

data class CountriesItem(
    @SerializedName("CodeTelePhone")
    val codeTelePhone: String,
    @SerializedName("ic_code")
    val icCode: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("Name")
    val name: String
)