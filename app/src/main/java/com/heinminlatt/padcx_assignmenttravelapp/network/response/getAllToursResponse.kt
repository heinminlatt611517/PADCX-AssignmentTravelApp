package com.heinminlatt.padcx_assignmenttravelapp.network.response

import com.google.gson.annotations.SerializedName
import com.heinminlatt.padcx_assignmenttravelapp.Utils.CODE_RESPONSE_OK
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO

data class getAllToursResponse (
    @SerializedName("code") val code : Int=0,
    @SerializedName("message") val message : String ="",
    @SerializedName("data") val data: ToursVO
){
    fun isResponseOK(): Boolean= (code == CODE_RESPONSE_OK) && (data != null)
}


