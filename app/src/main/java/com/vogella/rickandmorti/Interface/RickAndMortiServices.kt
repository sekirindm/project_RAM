package com.vogella.rickandmorti.Interface


import com.vogella.rickandmorti.Model.RickAndMortiClient
import com.vogella.rickandmorti.Model.RickAndMortiInfo
import retrofit2.Call
import retrofit2.http.GET

 interface RickAndMortiServices {
    @GET("character")
    fun getCharacterList() : Call<MutableList<RickAndMortiInfo>>


}