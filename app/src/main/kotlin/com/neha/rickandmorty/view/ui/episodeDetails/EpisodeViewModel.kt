package com.neha.rickandmorty.view.ui.episodeDetails

import androidx.lifecycle.MutableLiveData

class EpisodeViewModel: com.neha.rickandmorty.base.BaseViewModel() {
    private val episdoeURL = MutableLiveData<String>()

    fun bind(post: String){
        episdoeURL.value = post

    }

    fun episdoeURL(): MutableLiveData<String> {
        return episdoeURL
    }


}