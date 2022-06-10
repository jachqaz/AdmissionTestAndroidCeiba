package com.admissiontest.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admissiontest.R
import com.admissiontest.databinding.ItemUserBinding
import com.admissiontest.domain.model.Post
import com.admissiontest.domain.model.User
import com.google.android.material.textview.MaterialTextView


class MainUserAdapter(
    private val context: Context,
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
        val setPost =
            dataSetPost.filter { post -> post.userId == dataSetUser[position].id?.toInt() }
        if (setPost.isNotEmpty()) {
            holder.binding.tvPost.text = context.getString(R.string.hide_publications)
        }
        holder.binding.rvPosts.adapter = MainPostAdapter(setPost)
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
                if ((it as MaterialTextView).text == HIDE_POST) {
                    binding.rvPosts.adapter = MainPostAdapter(listOf())
                    it.text = context.getString(R.string.show_publications)
                } else {
                    listener.goToPostListener(dataSetUser[adapterPosition])
                }
            }
        }
    }

    companion object {
        const val HIDE_POST = "OCULTAR PUBLICACIONES"
    }

}
