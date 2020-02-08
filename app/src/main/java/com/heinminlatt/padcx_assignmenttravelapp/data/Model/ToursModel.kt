package com.heinminlatt.padcx_assignmenttravelapp.data.Model

import android.hardware.camera2.CaptureFailure
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.CountryVO
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO

interface ToursModel {
    fun getAllTours(onSuccess : (ToursVO)-> Unit,
                    onFailure: (String) -> Unit)

    fun getToursByName(toursName : String ) : CountryVO


}