package com.admissiontest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admissiontest.databinding.ItemUserBinding
import com.admissiontest.domain.model.Post
import com.admissiontest.domain.model.User


class MainUserAdapter(
    private val listener: PostListener,
    private val dataSetUser: List<User>,
    private val dataSetPost: List<Post> = listOf(),
) :
    RecyclerView.Adapter<MainUserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.binding.tvName.text = dataSetUser[position].name
        holder.binding.tvPhone.text = dataSetUser[position].phone
        holder.binding.tvEmail.text = dataSetUser[position].email
        holder.binding.rvPosts.adapter = MainPostAdapter(dataSetPost)
    }

    override fun getItemCount(): Int {
        return dataSetUser.size
    }

    interface PostListener {
        fun goToPostListener(user: User)
    }

    inner class ViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.executePendingBindings()
            binding.tvPost.setOnClickListener {
                listener.goToPostListener(dataSetUser[adapterPosition])
            }
        }
    }

}
