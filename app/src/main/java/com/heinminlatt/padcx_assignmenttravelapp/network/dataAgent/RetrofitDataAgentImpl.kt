package com.heinminlatt.padcx_assignmenttravelapp.network.dataAgent


import com.heinminlatt.padcx_assignmenttravelapp.Utils.BASE_URL
import com.heinminlatt.padcx_assignmenttravelapp.Utils.EN_NO_INTERNET_CONNECTION
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.CountryVO
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO
import com.heinminlatt.padcx_assignmenttravelapp.network.ToursApi
import com.heinminlatt.padcx_assignmenttravelapp.network.response.getAllToursResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl : ToursDataAgent {

    private var mToursApi : ToursApi? = null

    init {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        mToursApi=retrofit.create(ToursApi::class.java)

    }
    override fun getAllTours(onSuccess : (ToursVO)->Unit,
                             onFailure : (String)-> Unit) {
       val getAlltours= mToursApi?.getAllTours()
        getAlltours?.enqueue(object :Callback<getAllToursResponse>{
            override fun onFailure(call: Call<getAllToursResponse>, t: Throwable) {
                onFailure(t.message ?: EN_NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<getAllToursResponse>,
                response: Response<getAllToursResponse>
            ) {
                val result=response.body()
                if (result != null){
                    if (result.isResponseOK()){
                        result.data?.let {
                            onSuccess(it)
                        }
                    }
                    else{
                        onFailure(result.message)
                    }
                }
            }

        })
    }

}