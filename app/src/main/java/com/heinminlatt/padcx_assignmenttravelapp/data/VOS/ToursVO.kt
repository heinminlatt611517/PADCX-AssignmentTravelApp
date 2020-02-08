package com.heinminlatt.padcx_assignmenttravelapp.data.VOS

import com.google.gson.annotations.SerializedName

data class ToursVO(

    @SerializedName("country")
    val countrry: ArrayList<CountryVO> = arrayListOf(),

    @SerializedName("popular_tours")
    val popular_tours: ArrayList<CountryVO> = arrayListOf()
)

