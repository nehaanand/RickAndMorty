package com.neha.rickandmorty.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import com.neha.rickandmorty.model.database.AppDatabase
import com.neha.rickandmorty.viewmodel.characters.CharactersListViewModel

class ViewModelFactory(private val activity: AppCompatActivity, val episodeArray:ArrayList<String>): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         if (modelClass.isAssignableFrom(CharactersListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharactersListViewModel(episodeArray) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}