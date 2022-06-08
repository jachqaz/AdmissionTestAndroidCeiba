package com.admissiontest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admissiontest.databinding.ItemUserBinding
import com.admissiontest.domain.model.User


class MainAdapter(
    private val dataSet: List<User>,
    private val listener: PostListener
) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.binding.tvName.text = dataSet[position].name
        holder.binding.tvPhone.text = dataSet[position].phone
        holder.binding.tvEmail.text = dataSet[position].email
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    interface PostListener {
        fun goToPostListener(user: User)
    }

    inner class ViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.executePendingBindings()
            binding.tvPost.setOnClickListener {
                listener.goToPostListener(dataSet[adapterPosition])
            }
        }
    }

}
