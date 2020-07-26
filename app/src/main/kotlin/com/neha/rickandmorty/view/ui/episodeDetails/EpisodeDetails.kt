package com.neha.rickandmorty.view.ui.episodeDetails

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neha.rickandmorty.R
import com.neha.rickandmorty.viewmodel.characters.CharactersListViewModel

class EpisodeDetails : AppCompatActivity() {

    private lateinit var binding:com.neha.rickandmorty.databinding.ActivityEpisodeDetailsBinding
    private lateinit var viewModel: CharactersListViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_episode_details);
//        binding.rvCharacters.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, com.neha.rickandmorty.injection.ViewModelFactory(this, intent.getStringArrayListExtra("episodeArray"))).get(CharactersListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })

        binding.viewModel = viewModel

    } private fun showError(@StringRes errorMessage:String){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}