package com.heinminlatt.padcx_assignmenttravelapp.data.Model

import com.heinminlatt.padcx_assignmenttravelapp.network.dataAgent.RetrofitDataAgentImpl
import com.heinminlatt.padcx_assignmenttravelapp.network.dataAgent.ToursDataAgent

abstract class BaseModel {
     val mDataAgent : ToursDataAgent=RetrofitDataAgentImpl
}