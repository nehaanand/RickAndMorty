package com.neha.rickandmorty.viewmodel.episodes

import androidx.lifecycle.MutableLiveData
import android.view.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.neha.rickandmorty.model.EpisodeResponseModel
import com.neha.rickandmorty.model.Result
import com.neha.rickandmorty.network.APIsMethods
import com.neha.rickandmorty.view.adapter.EpisodesListAdapter
import javax.inject.Inject

class EpisodesListViewModel : com.neha.rickandmorty.base.BaseViewModel() {
    @Inject
    lateinit var postApi: APIsMethods
    val charactersListAdapter: EpisodesListAdapter = EpisodesListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadEpisodes() }

    private lateinit var subscription: Disposable

    init {
        loadEpisodes()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadEpisodes() {

        postApi.getEpisodesList().concatMap { apiPostList ->
            apiPostList
            Observable.just(apiPostList)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveEpisodesListStart() }
                .doOnTerminate { onRetrieveEpisodesListFinish() }

                .subscribe(
                        { result -> onRetrieveEpisodesListSuccess(result.episode) },
                        { error -> onRetrieveEpisodesListError(error) }
                )
    }

    private fun onRetrieveEpisodesListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveEpisodesListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveEpisodesListSuccess(charactersList: List<String>) {


//        charactersListAdapter.updateEpisodesList(charactersList)
//        loadingVisibility.value = View.GONE
//
//        Log.d("fdh","jkds");
    }

    private fun onRetrieveEpisodesListError(throwable: Throwable) {
        errorMessage.value = throwable.toString()
    }
}