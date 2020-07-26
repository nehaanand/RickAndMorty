package com.neha.rickandmorty.model


import com.google.gson.annotations.SerializedName

data class CharactersListModel1(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)