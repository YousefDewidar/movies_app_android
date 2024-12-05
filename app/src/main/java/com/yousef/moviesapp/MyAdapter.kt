package com.yousef.moviesapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MyAdapter(private var items: List<Movie>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    //  بعرف الadapter ان انا هشتغل علي movie_item وببعته ل my view holder عشان يتسخرج العناصر اللي جواه
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MyViewHolder(view)
    }

    //    مسكت كل عنصر في ال item الجديده بتاعتي
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.movie_title)
        val description: TextView = itemView.findViewById(R.id.movie_description)
        val image: ImageView = itemView.findViewById(R.id.movie_image)
        val rate: TextView = itemView.findViewById(R.id.rate)
        val date: TextView = itemView.findViewById(R.id.movie_release_date)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //    بحط قيم للعناصر اللي انا مسكتها في my view holder كل عنصر وترتيبه
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.rate.text = items[position].rate.toString()
        holder.date.text = items[position].date
        holder.description.text = items[position].desc
        holder.image.setImageResource(items[position].img)
    }


    fun updateList(newList: List<Movie>) {
        val myDiffUtil = MyDiffUtil(oldList = this.items, newList = newList)
        val difResult: DiffResult = DiffUtil.calculateDiff(myDiffUtil)
        this.items = newList
        difResult.dispatchUpdatesTo(this)

    }
}

