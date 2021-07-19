package com.anta40.app.seafoodapp.data

import com.anta40.app.seafoodapp.model.Meal
import com.anta40.app.seafoodapp.model.MealList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("filter.php")
    fun getFoodList(@Query("c") food_type: String) : Call<MealList>
    //suspend fun getFoodList(@Query("c") food_type: String) : Response<MealList>
}