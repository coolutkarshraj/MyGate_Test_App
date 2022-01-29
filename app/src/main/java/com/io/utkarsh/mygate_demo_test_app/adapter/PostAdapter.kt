package com.io.utkarsh.mygate_demo_test_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.io.utkarsh.mygate_demo_test_app.databinding.ItemViewLayoutBinding
import com.io.utkarsh.mygate_demo_test_app.model.Post

class PostAdapter(private var postList :List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private lateinit var binding: ItemViewLayoutBinding
    class PostViewHolder(itemView :View) :RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = ItemViewLayoutBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.textViewTitle.text = postList[position].title
        binding.textViewDescription.text = postList[position].body
        binding.textViewDescription.text = postList[position].body
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setDate(postList: List<Post>){
      this.postList =postList
        notifyDataSetChanged()
    }
}