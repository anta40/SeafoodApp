package com.anta40.app.seafoodapp.repository

import com.anta40.app.seafoodapp.data.ApiClient
import com.anta40.app.seafoodapp.model.MealList
import retrofit2.Call

object MainActivityRepository {

    fun getSeafoodListApiCall(): Call<MealList> {

        val call = ApiClient.apiInterface.getSeafoodList("Seafood")

        return call
    }


}