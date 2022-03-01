package com.example.mainexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Myadapter(private var userlist: List<User>, private var clickListener:(User) -> Unit) :
    RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    class MyViewHolder(itemView: View, clickposition: (Int) ->Unit) : RecyclerView.ViewHolder(itemView) {

        val userName: TextView = itemView.findViewById(R.id.movie_name)


        init {


            userName.setOnClickListener {

                clickposition(absoluteAdapterPosition)


            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewholder = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(viewholder){
            clickListener(userlist[it])
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userlist[position]

        holder.userName.text = currentItem.firstName



    }
    override fun getItemCount(): Int = userlist.size

}