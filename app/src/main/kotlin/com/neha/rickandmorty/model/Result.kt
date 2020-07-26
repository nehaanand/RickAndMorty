package com.neha.rickandmorty.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: ArrayList<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("resultid")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)