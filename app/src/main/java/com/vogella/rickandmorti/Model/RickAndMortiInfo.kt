package com.vogella.rickandmorti.Model

import com.google.gson.annotations.SerializedName

data class RickAndMortiInfo (
@SerializedName("info") val info : Info,
@SerializedName("results") val results: Results
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
        @SerializedName("name") var name: String,
        @SerializedName("status") var status: String,
        @SerializedName ("species") val species: String,
        @SerializedName("type") val type: String,
        @SerializedName("gender") val gender: String,
        @SerializedName("image") var image: String,
        @SerializedName("url") val url: String,
        @SerializedName("created") val created: String
)
