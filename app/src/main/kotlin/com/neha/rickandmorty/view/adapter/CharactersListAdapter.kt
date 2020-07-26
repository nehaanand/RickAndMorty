package com.neha.rickandmorty.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.neha.rickandmorty.view.ui.episodeDetails.EpisodeDetails
import com.neha.rickandmorty.model.Result
import com.neha.rickandmorty.view.ui.characters.CharacterViewModel
import com.neha.rickandmorty.view.ui.episodeDetails.EpisodeViewModel


class CharactersListAdapter : BaseAdapter {
    //    var foodsList = ArrayList<Food>()
    private lateinit var postList: List<Result>
    var epiList = arrayListOf<String>()


    var context: Context? = null

    constructor() : super() {
//        this.context = context
    }

    override fun getCount(): Int {
       return if (::postList.isInitialized ) postList.size else epiList.size
    }

    override fun getItem(position: Int): Any {

        return postList[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun updateCharactersList(postList: List<Result>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    fun updateEpiList(epiList: ArrayList<String>) {
        this.epiList = epiList
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var inflator = parent?.context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


//        convertView?.setOnClickListener {
//
//            val intent = Intent(parent.context, EpisodeDetails::class.java)
//            intent.putStringArrayListExtra("episodeArray", postList[position].episode)
//            parent.context.startActivity(intent)
//
//        }

//        foodView.imgFood.setOnClickListener {
//
//            val intent = Intent(context, FoodDetails::class.java)
//            intent.putExtra("name", food.name!!)
//            intent.putExtra("description", food.description!!)
//            intent.putExtra("image", food.image!!)
//            context!!.startActivity(intent)
//        }
//        val clickListener = View.OnClickListener {convertView ->
//
//
//            val intent = Intent(parent.context, EpisodeDetails::class.java)
//            intent.putStringArrayListExtra("episodeArray", postList[position].episode)
//            parent.context.startActivity(intent)
//
//        }

        if (epiList.size>0) {
            var binding: com.neha.rickandmorty.databinding.ItemEpisodeList1Binding = DataBindingUtil.inflate(inflator, com.neha.rickandmorty.R.layout.item_episode_list1, parent, false)


            val viewModel = EpisodeViewModel()
            viewModel.bind(epiList[position])
            binding.viewModel = viewModel
            return binding.root

        }  else if (postList.size>0) {
            var binding: com.neha.rickandmorty.databinding.ItemCharactersList1Binding = DataBindingUtil.inflate(inflator, com.neha.rickandmorty.R.layout.item_characters_list1, parent, false)

            val viewModel = CharacterViewModel()
            viewModel.bind(postList[position])
            binding.viewModel = viewModel

            binding.imageView.setOnClickListener{
                val intent = Intent(parent.context, EpisodeDetails::class.java)
                intent.putStringArrayListExtra("episodeArray", postList[position].episode)
                parent.context.startActivity(intent)
            }
            return binding.root

        } else {
            var binding: com.neha.rickandmorty.databinding.ItemCharactersList1Binding = DataBindingUtil.inflate(inflator, com.neha.rickandmorty.R.layout.item_characters_list1, parent, false)

            val viewModel = CharacterViewModel()
            viewModel.bind(postList[position])
            binding.viewModel = viewModel
            return binding.root
        }
    }

}


//class CharactersListAdapter: RecyclerView.Adapter<CharactersListAdapter.ViewHolder>() {
//    override fun getItemCount(): Int {
//        return if(::postList.isInitialized) postList.size else 0
//
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    private lateinit var postList:List<Result>
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersListAdapter.ViewHolder {
//        val binding: ItemCharactersList1Binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_characters_list1, parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: CharactersListAdapter.ViewHolder, position: Int) {
//        holder.bind(postList[position])
//    }
//
//
//    fun updateCharactersList(postList:List<Result>){
//        this.postList = postList
//        notifyDataSetChanged()
//    }
//
//    class ViewHolder(private val binding: ItemCharactersList1Binding):RecyclerView.ViewHolder(binding.root){
//        private val viewModel = CharacterViewModel()
//
//        fun bind(post:Result){
//            viewModel.bind(post)
//            binding.viewModel = viewModel
//        }
//    }
//}

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