package com.neha.rickandmorty.viewmodel.characters

import androidx.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.neha.rickandmorty.model.Result
import com.neha.rickandmorty.network.APIsMethods
import com.neha.rickandmorty.view.adapter.CharactersListAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharactersListViewModel(episodeArray:ArrayList<String>) : com.neha.rickandmorty.base.BaseViewModel() {
    @Inject
    lateinit var postApi: APIsMethods
    val charactersListAdapter: CharactersListAdapter = CharactersListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    val errorClickListener = View.OnClickListener { loadCharacterss(episodeArray) }

    private lateinit var subscription: Disposable

    init {
        loadCharacterss(episodeArray)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadCharacterss(episodeArray:ArrayList<String> ) {


        if (episodeArray.isEmpty()){
            postApi.getCharactersList().concatMap { apiPostList ->
                apiPostList
                Observable.just(apiPostList)
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { onRetrieveCharactersListStart() }
                    .doOnTerminate { onRetrieveCharactersListFinish() }

                    .subscribe(
                            { result -> onRetrieveCharactersListSuccess(result.results).toString() },
                            { error -> onRetrieveCharactersListError(error) }
                    )
        }
        else {

//            for (id in episodeArray) {
                postApi.getCharactersList().concatMap { apiPostList ->   //it will change
                    apiPostList
                    Observable.just(apiPostList)
                }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe { onRetrieveCharactersListStart() }
                        .doOnTerminate { onRetrieveCharactersListFinish() }

                        .subscribe(
                                { result -> onRetrieveEpisodeListSuccess(episodeArray).toString() },
                                { error -> onRetrieveCharactersListError(error) }
                        )

//            }
        }



    }

    private fun onRetrieveCharactersListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveCharactersListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCharactersListSuccess(charactersList: List<Result>) {


        charactersListAdapter.updateCharactersList(charactersList)
        loadingVisibility.value = View.GONE

        Log.d("fdh","jkds");
    }

    private fun onRetrieveEpisodeListSuccess(epiList: ArrayList<String>) {


        charactersListAdapter.updateEpiList(epiList)
        loadingVisibility.value = View.GONE

        Log.d("fdh","jkds");
    }

    private fun onRetrieveCharactersListError(throwable: Throwable) {
        errorMessage.value = throwable.toString()
    }
}