package com.example.dnevnadozaradovanja

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("YbbIIi")
    fun getData(): Call<List<MyDataItem>>
}