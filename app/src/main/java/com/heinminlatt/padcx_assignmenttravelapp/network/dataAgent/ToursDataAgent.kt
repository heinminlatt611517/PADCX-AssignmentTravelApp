package com.heinminlatt.padcx_assignmenttravelapp.network.dataAgent

import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.CountryVO
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO

interface ToursDataAgent {
    fun getAllTours(onSuccess : (ToursVO)->Unit,
                    onFailure : (String) -> Unit)
}