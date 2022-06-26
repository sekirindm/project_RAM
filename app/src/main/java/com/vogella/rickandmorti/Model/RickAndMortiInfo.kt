package com.vogella.rickandmorti.Model

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Array

data class RickAndMortiInfo(
    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: List<Results>
) {

}

data class Info(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String,
    @SerializedName("prev") val prev: String
)

data class Results(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("image") val image: String,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String,
    @SerializedName("location") val location: Location,
    @SerializedName("origin") val origin: Origin

)

data class Location(
    @SerializedName("name") val name: String
)

data class Origin(
    @SerializedName("name") val name: String
)
