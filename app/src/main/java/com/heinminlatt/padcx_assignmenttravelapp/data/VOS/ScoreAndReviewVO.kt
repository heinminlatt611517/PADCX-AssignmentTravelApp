package com.heinminlatt.padcx_assignmenttravelapp.data.VOS

import com.google.gson.annotations.SerializedName

data class ScoreAndReviewVO (
    @SerializedName("name") val name : String="",
    @SerializedName("score") val score : Float,
    @SerializedName("max_score") val max_score : Int=0,
    @SerializedName("total_reviews") val totleReview : Int =0

)
