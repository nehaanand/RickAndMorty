package com.neha.rickandmorty.view.ui.characters

import androidx.lifecycle.Observer
import com.neha.rickandmorty.R
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neha.rickandmorty.viewmodel.characters.CharactersListViewModel

class List_of_Characters : AppCompatActivity() {

    private lateinit var binding:com.neha.rickandmorty.databinding.ListOfCharactersActivityBinding
    private lateinit var viewModel: CharactersListViewModel
    private var errorSnackbar: Snackbar? = null
    val ids: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.list_of__characters_activity);
//        binding.rvCharacters.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, com.neha.rickandmorty.injection.ViewModelFactory(this, ids)).get(CharactersListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage.toInt()) else hideError()
        })

        binding.viewModel = viewModel

    } private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}