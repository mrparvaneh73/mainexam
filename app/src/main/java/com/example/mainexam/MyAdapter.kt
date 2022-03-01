package com.example.mainexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Myadapter(private var userlist: List<User> ) :
    RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val movieName: TextView = itemView.findViewById(R.id.movie_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewholder = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(viewholder)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userlist[position]

        holder.movieName.text = currentItem.firstName



    }
    override fun getItemCount(): Int = userlist.size

}