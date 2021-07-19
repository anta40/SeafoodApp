package com.anta40.app.seafoodapp.data

import com.anta40.app.seafoodapp.model.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("filter.php")
    fun getSeafoodList(@Query("c") food_type: String) : Call<MealList>
}