package com.vogella.rickandmorti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import com.vogella.rickandmorti.Adapter.RickAndMortiAdapter
import com.vogella.rickandmorti.Model.Results
import kotlinx.android.synthetic.main.activity_main_descriptions.*


class MainActivityDescriptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_descriptions)

        val url = intent.getStringExtra("url")
        Picasso.get().load(url).into(imageViewPersonAvaDescriptions)


        val name = intent.getStringExtra("name")
        textViewNameDescriptions.text = name

        val location = intent.getStringExtra("location")
        textViewLocationInfo.text = location

        val gender = intent.getStringExtra("gender")
       textViewGenderInfo.text = gender

        val type = intent.getStringExtra("type")
        textViewTypeInfo.text = type

        val origin = intent.getStringExtra("origin")
        textViewOriginInfo.text = origin

        val status = intent.getStringExtra("status")?:""
        textViewStatusDescrLife.text = status

        val species = intent.getStringExtra("species")
        textViewSpeciesDescr.text = species

//        val image = intent.getStringExtra("image")
//        Picasso.get().load(image).into(imageViewStatusDescrRed)
//        Picasso.get().load(image).into(imageViewStatusDescrGreen)
//        Picasso.get().load(image).into(imageViewStatusDescrWhite)

        bindStatusNewActivity(status)



    }

//    fun bind1(results: Results) {
//        val lifeStatusDescriptions = results.status
//        bindStatusNewActivity(lifeStatusDescriptions)
//    }
//
    fun bindStatusNewActivity(status: String) {
        when {
            status.lowercase() == "alive" -> {
                imageViewStatusDescrGreen.visibility = View.VISIBLE
                imageViewStatusDescrRed.visibility = View.GONE
                imageViewStatusDescrWhite.visibility = View.GONE
            }
            status.lowercase() == "dead" -> {
                imageViewStatusDescrGreen.visibility = View.GONE
                imageViewStatusDescrRed.visibility = View.VISIBLE
                imageViewStatusDescrWhite.visibility = View.GONE
            }
            else -> {
                imageViewStatusDescrGreen.visibility = View.GONE
                imageViewStatusDescrRed.visibility = View.GONE
                imageViewStatusDescrWhite.visibility = View.VISIBLE
            }
        }

    }






        fun onClickBackActivity(view: View) {
            finish()

        }
    }
