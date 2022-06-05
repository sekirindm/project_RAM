package com.vogella.rickandmorti.Model

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName

data class RickAndMortiInfo(
    @SerializedName("info") val info: List<Info>,
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
    @SerializedName("created") val created: String
)