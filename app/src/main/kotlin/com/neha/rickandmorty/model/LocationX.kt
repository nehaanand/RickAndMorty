package com.neha.rickandmorty.model


import com.google.gson.annotations.SerializedName

data class LocationX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)