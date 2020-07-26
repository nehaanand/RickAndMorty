package com.neha.rickandmorty.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.neha.rickandmorty.utils.extension.getParentActivity
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso



@BindingAdapter("adapter")
fun setAdapter(view: androidx.recyclerview.widget.RecyclerView, adapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View,  visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView,  text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso.with(view.getContext())
            .load(imageUrl)
            .placeholder(android.R.drawable.ic_delete)
            .into(view)

}