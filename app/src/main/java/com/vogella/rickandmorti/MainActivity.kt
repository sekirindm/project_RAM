package com.vogella.rickandmorti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vogella.rickandmorti.Adapter.RickAndMortiAdapter
import com.vogella.rickandmorti.Common.Common
import com.vogella.rickandmorti.Interface.RickAndMortiServices
import com.vogella.rickandmorti.Model.Results
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

        mService = Common.rickAndMortiServices
        recyclerList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerList.layoutManager = layoutManager

        getAllRAMList()
    }

    fun getAllRAMList() {
        mService.getCharacterList().enqueue(object : Callback <MutableList<Results>> {
            override fun onResponse(
                call: Call<MutableList<Results>>,
                response: Response<MutableList<Results>>
            ) {
                adapter = RickAndMortiAdapter(baseContext, response.body() as MutableList<Results>)
                adapter.notifyDataSetChanged()
                recyclerList.adapter = adapter

            }

            override fun onFailure(call: Call<MutableList<Results>>, t: Throwable) {

            }

        })
    }
}