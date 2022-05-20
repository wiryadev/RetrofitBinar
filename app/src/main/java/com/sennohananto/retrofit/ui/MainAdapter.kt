package com.sennohananto.retrofit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sennohananto.retrofit.data.model.GetAllPostsResponseItem
import com.sennohananto.retrofit.databinding.ItemListBinding

class MainAdapter(
    private val onPostClicked: (GetAllPostsResponseItem) -> Unit
) : ListAdapter<GetAllPostsResponseItem, MainAdapter.MainViewHolder>(DIFF_CALLBACK) {

    inner class MainViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GetAllPostsResponseItem) {

            with(binding) {
                tvTitle.text = data.title
                root.setOnClickListener {
                    onPostClicked.invoke(data)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = getItem(position)
        data?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GetAllPostsResponseItem>() {
            override fun areItemsTheSame(
                oldItem: GetAllPostsResponseItem,
                newItem: GetAllPostsResponseItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GetAllPostsResponseItem,
                newItem: GetAllPostsResponseItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}