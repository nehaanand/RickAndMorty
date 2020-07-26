package com.neha.rickandmorty.model


import com.google.gson.annotations.SerializedName

data class OriginX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)