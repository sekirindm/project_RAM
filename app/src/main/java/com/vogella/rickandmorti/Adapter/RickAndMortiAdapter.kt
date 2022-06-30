package com.vogella.rickandmorti.Adapter

import android.content.Context
import android.graphics.LinearGradient
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vogella.rickandmorti.Model.Results
import com.vogella.rickandmorti.R
import com.vogella.rickandmorti.R.drawable
import kotlinx.android.synthetic.main.item_layout.view.*

class RickAndMortiAdapter(
    private val context: Context,
    private val rickAndMortiList: List<Results>
) : RecyclerView.Adapter<RickAndMortiAdapter.MyViewHolder>() {

    lateinit var clickLister: AdapterClickLister

    fun setOnClickListener(adapterOnClick: AdapterClickLister) {
        clickLister = adapterOnClick
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val imageViewPersonAva: ImageView = itemView.imageViewPersonAva
        val textViewStatusLife: TextView = itemView.textViewStatusLife
        var textViewName: TextView = itemView.textViewName
        var imageViewStatusGreen: ImageView = itemView.imageViewStatusGreen
        val textViewSpecies: TextView = itemView.textViewSpecies
        val textViewLastLocation: TextView = itemView.textViewLastLocation
        val textViewOriginInfor: TextView = itemView.textViewOriginInfor

        fun bind(results: Results) {
            textViewName.text = results.name
            textViewStatusLife.text = results.status
            textViewSpecies.text = results.species
            textViewLastLocation.text = results.location.name
            textViewOriginInfor.text = results.origin.name
            Picasso.get().load(results.image).into(imageViewPersonAva)

            val lifeStatus = results.status
            bindStatus(lifeStatus)


            itemView.setOnClickListener {
                clickLister.onClick(
                    results.image,
                    results.name,
                    results.status,
                    results.type,
                    results.gender,
                    results.location.name,
                    results.image,
                    results.origin.name,
                    results.species
                )

            }

        }

        ////
        fun bindStatus(status: String) {
            val imageStatus = when {
                status.lowercase() == "alive" -> {
                    drawable.image_status_green
                }
                status.lowercase() == "dead" -> {
                    drawable.image_status_red
                }
                else -> {
                    drawable.image_status_white
                }

            }
//            Picasso.get().load(imageStatus).into(imageViewStatusGreen)
            imageViewStatusGreen.setImageResource(imageStatus)

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val results = rickAndMortiList[position]
        holder.bind(results)


    }

    override fun getItemCount() = rickAndMortiList.size

    interface AdapterClickLister {
        fun onClick(
            url: String,
            name: String,
            status: String,
            type: String,
            gender: String,
            location: String,
            image: String,
            origin: String,
            species: String
        )


    }

}

