package com.neha.rickandmorty.network

import com.neha.rickandmorty.model.CharactersListModel1
import com.neha.rickandmorty.model.EpisodeResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface APIsMethods {
    /**
     * Get the list of the pots from the API
     */


    @GET("character")
    fun getCharactersList(): Observable<CharactersListModel1>

    @GET("character/")
    fun getEpisodesList(): Observable<EpisodeResponseModel>
}