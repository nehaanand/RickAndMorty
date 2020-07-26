package com.neha.rickandmorty.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.neha.rickandmorty.R
import com.neha.rickandmorty.model.EpisodeResponseModel
import com.neha.rickandmorty.model.Result
import com.neha.rickandmorty.view.ui.characters.CharacterViewModel
import com.neha.rickandmorty.view.ui.episodeDetails.EpisodeViewModel


class EpisodesListAdapter: androidx.recyclerview.widget.RecyclerView.Adapter<EpisodesListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var postList:List<EpisodeResponseModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesListAdapter.ViewHolder {
        val binding: com.neha.rickandmorty.databinding.ItemCharactersList1Binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_characters_list1, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodesListAdapter.ViewHolder, position: Int) {
        holder.bind(postList[position])
    }


    fun updateEpisodesList(postList:List<EpisodeResponseModel>){
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: com.neha.rickandmorty.databinding.ItemCharactersList1Binding): androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){
        private val viewModel = EpisodeViewModel()

        fun bind(post:EpisodeResponseModel){
//            viewModel.bind(post)
//            binding.viewModel = viewModel
        }
    }
}

//class CharactersListAdapter : RecyclerView.Adapter<CharactersListAdapter.ViewHolder>(){
//
//    private lateinit var characterslist:Observable<CharactersListModel1>
//
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
//              val binding: com.neha.rickandmorty.databinding.ActivityCharactersListBinding = DataBindingUtil.inflate(LayoutInflater.from(p0.context), R.layout.item_post1, p0, false)
//        return PostListAdapter.ViewHolder(binding)
//    }
//    override fun getItemCount(): Int {
//        return if(::characterslist.isInitialized) characterslist.size else 0
//
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {
//        holder.bind(characterslist[p1])
//
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    fun updateCharactersList(characterslist: Observable<CharactersListModel1>){
//        this.characterslist = characterslist
//        notifyDataSetChanged()
//    }
//
//    class ViewHolder(private val binding: com.neha.rickandmorty.databinding.ActivityCharactersListBinding):RecyclerView.ViewHolder(binding.root){
//        private val viewModel = CharacterViewModel()
//
//        fun bind(post:CharactersListModel1){
//            viewModel.bind(post)
//            binding.viewModel = viewModel
//        }
//    }
//
//
//}