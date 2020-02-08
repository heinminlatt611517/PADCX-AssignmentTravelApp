package com.heinminlatt.padcx_assignmenttravelapp.network

import com.heinminlatt.padcx_assignmenttravelapp.Utils.GET_TOURS
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO
import com.heinminlatt.padcx_assignmenttravelapp.network.response.getAllToursResponse
import retrofit2.Call
import retrofit2.http.GET

interface ToursApi {
    @GET(GET_TOURS)
    fun getAllTours() : Call<getAllToursResponse>

}