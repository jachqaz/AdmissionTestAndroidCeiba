package com.admissiontest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admissiontest.databinding.ItemPostBinding
import com.admissiontest.domain.model.Post


class MainPostAdapter(private val dataSetPost: List<Post>) :
    RecyclerView.Adapter<MainPostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.binding.tvTitle.text = dataSetPost[position].title
        holder.binding.tvBody.text = dataSetPost[position].body
    }

    override fun getItemCount(): Int {
        return dataSetPost.size
    }

    inner class ViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.executePendingBindings()
        }
    }
}
