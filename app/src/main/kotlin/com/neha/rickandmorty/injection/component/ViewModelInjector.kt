package com.neha.rickandmorty.injection.component

import dagger.Component
import com.neha.rickandmorty.injection.module.NetworkModule
import com.neha.rickandmorty.viewmodel.characters.CharactersListViewModel
import com.neha.rickandmorty.view.ui.characters.CharacterViewModel
import com.neha.rickandmorty.view.ui.episodeDetails.EpisodeViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param postViewModel PostViewModel in which to inject the dependencies
     */

    fun inject(charactersListViewModel: CharactersListViewModel)
    fun inject(characterViewModel: CharacterViewModel)
    fun inject(episodeViewModel: EpisodeViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}