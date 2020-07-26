package com.neha.rickandmorty.base

import androidx.lifecycle.ViewModel
import com.neha.rickandmorty.injection.component.ViewModelInjector
import com.neha.rickandmorty.injection.component.DaggerViewModelInjector
import com.neha.rickandmorty.injection.module.NetworkModule
import com.neha.rickandmorty.view.ui.characters.CharacterViewModel
import com.neha.rickandmorty.view.ui.episodeDetails.EpisodeViewModel
import com.neha.rickandmorty.viewmodel.characters.CharactersListViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CharactersListViewModel -> injector.inject(this)
            is CharacterViewModel -> injector.inject(this)
            is EpisodeViewModel -> injector.inject(this)
        }
    }
}