package com.heinminlatt.padcx_assignmenttravelapp.data.VOS

import com.google.gson.annotations.SerializedName

data class CountryVO (
    @SerializedName("name") val name : String ="",
    @SerializedName("description") val description : String="",
    @SerializedName("location") val location : String="",
    @SerializedName("average_rating") val averageRating : Float,
    @SerializedName("scores_and_reviews") val scoreAndreview : ArrayList<ScoreAndReviewVO>? = arrayListOf(),
    @SerializedName("photos") val photo : ArrayList<String>? = arrayListOf()
)
