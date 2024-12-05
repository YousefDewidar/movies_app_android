package com.yousef.moviesapp

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList: List<Movie>,
    private val newList: List<Movie>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem: Movie = oldList[oldItemPosition]
        val newItem: Movie = newList[newItemPosition]

        return (oldItem.title == newItem.title) &&
                (oldItem.date == newItem.date) &&
                (oldItem.rate == newItem.rate) &&
                (oldItem.img == newItem.img) &&
                (oldItem.desc == newItem.desc)

    }
}