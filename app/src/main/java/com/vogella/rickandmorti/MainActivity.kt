package com.vogella.rickandmorti

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vogella.rickandmorti.Adapter.RickAndMortiAdapter
import com.vogella.rickandmorti.Common.Common
import com.vogella.rickandmorti.Interface.RickAndMortiServices
import com.vogella.rickandmorti.Model.RickAndMortiInfo
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var mService: RickAndMortiServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: RickAndMortiAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       cardViewList.setOnClickListener{
//           goToXScreen()
//       }

        mService = Common.rickAndMortiServices
        recyclerList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerList.layoutManager = layoutManager


        getAllRAMList()
    }


    fun goToXScreen(
        url: String,
        name: String,
        status: String,
        type: String,
        gender: String,
        location: String,
        image: String,
        origin: String,
        species: String
    ) {
        Intent(this, MainActivityDescriptions::class.java).apply {
            putExtra("url", url)
            putExtra("name", name)
            putExtra("status", status)
            putExtra("type", type)
            putExtra("gender", gender)
            putExtra("origin", origin)
            putExtra("location", location)
            putExtra("image", image)
            putExtra("species", species)
            startActivity(this)
        }

    }


    fun getAllRAMList() {
        mService.getCharacterList().enqueue(object : Callback<RickAndMortiInfo> {
            override fun onResponse(
                call: Call<RickAndMortiInfo>,
                response: Response<RickAndMortiInfo>
            ) {
                val rickAndMortiInfo = response.body() as RickAndMortiInfo
                val results = rickAndMortiInfo.results

                adapter = RickAndMortiAdapter(baseContext, results)
                adapter.notifyDataSetChanged()
                recyclerList.adapter = adapter

                adapter.setOnClickListener(object : RickAndMortiAdapter.AdapterClickLister {
                    override fun onClick(
                        url: String,
                        name: String,
                        status: String,
                        type: String,
                        gender: String,
                        location: String,
                        image: String,
                        origin: String,
                        species: String
                    ) {


                        Toast.makeText(baseContext, "жмал", Toast.LENGTH_SHORT).show()
                        goToXScreen(
                            url,
                            name,
                            status,
                            type,
                            gender,
                            location,
                            image,
                            origin,
                            species
                        )

                    }


                })
            }

            override fun onFailure(call: Call<RickAndMortiInfo>, t: Throwable) {


            }

        })

    }

//     fun Main() {
//        var radius = 40
//        val pi = 3.14
//        val circumference = pi * radius * 2
//        print("Радиус: $circumference")
//
//    }
}


