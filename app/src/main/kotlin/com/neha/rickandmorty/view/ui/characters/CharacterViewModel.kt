package com.neha.rickandmorty.view.ui.characters

import androidx.lifecycle.MutableLiveData
import com.neha.rickandmorty.model.Result

class CharacterViewModel: com.neha.rickandmorty.base.BaseViewModel() {
    private val charName = MutableLiveData<String>()
    private val charGender = MutableLiveData<String>()
    private val charImage = MutableLiveData<String>()

    fun bind(post: Result){
        charName.value = post.name
        charGender.value = post.gender
        charImage.value = post.image
    }

    fun getCharName():MutableLiveData<String>{
        return charName
    }

    fun getCharGender():MutableLiveData<String>{
        return charGender
    }

    fun getCharImage():MutableLiveData<String>{
        return charImage
    }
}