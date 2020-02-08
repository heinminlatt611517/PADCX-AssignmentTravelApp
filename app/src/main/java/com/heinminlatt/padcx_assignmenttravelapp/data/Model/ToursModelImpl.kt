package com.heinminlatt.padcx_assignmenttravelapp.data.Model

import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.CountryVO
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO

object ToursModelImpl : ToursModel ,BaseModel(){


    var mToursRepository : HashMap<String,CountryVO> = hashMapOf()

    override fun getAllTours(onSuccess: (ToursVO) -> Unit, onFailure: (String) -> Unit) {
        mDataAgent.getAllTours(onSuccess = {
            it.countrry.forEach {
                mToursRepository[it.name]=it
            }
            it.popular_tours.forEach {
                mToursRepository[it.name]=it
            }
            onSuccess.invoke(it)
        },
            onFailure = {
                onFailure(it)
            })
    }


    override fun getToursByName(toursName: String): CountryVO {
      mToursRepository[toursName]?.let {
          return it
      }
        return CountryVO("","","",0.toFloat(), arrayListOf())
    }
}