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


        bindStatusNewActivity(status)



    }

    fun bindStatusNewActivity(status: String) {
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
//            Picasso.get().load(imageStatus).into(imageViewStatusGreen)
        imageViewStatusDescrGreen.setImageResource(imageStatus)

    }






        fun onClickBackActivity(view: View) {
            finish()

        }
    }
