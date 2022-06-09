package com.vogella.rickandmorti.Common

import com.vogella.rickandmorti.Interface.RickAndMortiServices
import com.vogella.rickandmorti.Model.RickAndMortiClient
import com.vogella.rickandmorti.Model.RickAndMortiInfo

object Common {
    private val BASE_URL = "https://rickandmortyapi.com/api/"
    val rickAndMortiServices : RickAndMortiServices
        get()= RickAndMortiClient.getClient(BASE_URL).create(RickAndMortiServices::class.java)
}