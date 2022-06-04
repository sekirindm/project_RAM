package com.vogella.rickandmorti.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickAndMortiClient {

        private var retrofit : Retrofit? = null

        fun getClient (baseURL : String): Retrofit {
            if(retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
