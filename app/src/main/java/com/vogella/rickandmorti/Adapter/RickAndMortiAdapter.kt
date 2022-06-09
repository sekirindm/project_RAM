package com.vogella.rickandmorti.Adapter

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vogella.rickandmorti.Model.Results
import com.vogella.rickandmorti.Model.RickAndMortiInfo
import com.vogella.rickandmorti.R
import kotlinx.android.synthetic.main.item_layout.view.*

class RickAndMortiAdapter(private val context: Context, private val rickAndMortiList: List<Results>) :    RecyclerView.Adapter<RickAndMortiAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View, ) : RecyclerView.ViewHolder(itemView){


        val imageViewPersonAva: ImageView = itemView.imageViewPersonAva
        val imageViewStatusColor: ImageView = itemView.imageViewStatusColor
        val textViewStatusLife: TextView = itemView.textViewStatusLife
        val textViewName: TextView = itemView.textViewName


    }


override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

   val listItem = rickAndMortiList[position]

        holder.textViewName.text = listItem.name
        holder.textViewStatusLife.text = listItem.status
        Picasso.get().load(listItem.image).into(holder.imageViewPersonAva)



    }

    override fun getItemCount() = rickAndMortiList.size


}