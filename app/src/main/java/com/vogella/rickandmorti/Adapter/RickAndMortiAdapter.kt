package com.vogella.rickandmorti.Adapter

import android.content.Context
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
        val textViewName: TextView = itemView.textViewName
        var imageViewStatusGreen: ImageView = itemView.imageViewStatusGreen
        val textViewSpecies: TextView = itemView.textViewSpecies
        val textViewLastLocation: TextView = itemView.textViewLastLocation
        val textViewOriginInfor: TextView = itemView.textViewOriginInfor
//        val imageViewStatusDescrWhite: ImageView = itemView.imageViewStatusDescrWhite
//        val imageViewStatusDescrRed: ImageView = itemView.imageViewStatusDescrRed
//        val imageViewStatusDescrGreen: ImageView = itemView.imageViewStatusDescrGreen


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

//
//            val statusLife =
//                if (isAlive)
//                    statusColorRed


//        val isAlive: Boolean =
//            if (lifeStatus.lowercase() == "alive")
//                true
//            else
//                false


//
//        val statusImage =
//            if (isAlive)
//                R.drawable.image_status_green
//        else
//            R.drawable.image_status_red


//
//        if (isAlive) {
////            Picasso.get().load(R.drawable.image_status_green).into(holder.imageViewStatusGreen)
//
//            holder.imageViewStatusGreen.visibility = View.VISIBLE
//            holder.imageViewStatusRed.visibility = View.GONE
//
//        } else {
//
//            holder.imageViewStatusGreen.visibility = View.GONE
//            holder.imageViewStatusRed.visibility = View.VISIBLE
//
//
//
//
////            Picasso.get().load(R.drawable.image_status_red).into(holder.imageViewStatusRed)
//        }
        }

        ////
        fun bindStatus(status: String) {
            val imageStatus = when {
                status.lowercase() == "alive" -> {
                    R.drawable.image_status_green
                }
                status.lowercase() == "dead" -> {
                    R.drawable.image_status_red
                }
                else -> {
                    R.drawable.image_status_white
                }

            }
            Picasso.get().load(imageStatus).into(imageViewStatusGreen)

        }

//        fun bindStatusNewActivity(status: String) {
//            when {
//                status.lowercase() == "alive" -> {
//                    if (lifeStatus.lowercase() == "alive") {
//                    Picasso.get().load(R.drawable.image_status_green)
//
//                } else if (lifeStatus.lowercase() == "dead") {
//                    Picasso.get().load(R.drawable.image_status_red)
//                } else {
//                    Picasso.get().load(R.drawable.image_status_white)
//                }
//                }
//                status.lowercase() == "dead" -> {
//                    imageViewStatusDescrGreen.visibility = View.GONE
//                    imageViewStatusDescrRed.visibility = View.VISIBLE
//                    imageViewStatusDescrWhite.visibility = View.GONE
//                }
//                else -> {
//                    imageViewStatusDescrGreen.visibility = View.GONE
//                    imageViewStatusDescrRed.visibility = View.GONE
//                    imageViewStatusDescrWhite.visibility = View.VISIBLE
//                }
//            }
//
//        }

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