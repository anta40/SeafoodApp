package com.anta40.app.seafoodapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anta40.app.seafoodapp.model.MealList
import com.anta40.app.seafoodapp.repository.MainActivityRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    private val _seafoodListLiveData = MutableLiveData<MealList>()
    val seafoodListLiveData: LiveData<MealList > = _seafoodListLiveData

    fun getData(){
        MainActivityRepository.getSeafoodListApiCall().enqueue(object: Callback<MealList> {
            override fun onResponse(
                call: Call<MealList>,
                response: Response<MealList>
            ) {
                val body = response.body()
                _seafoodListLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.e("MainViewModel", "onFailure: ", t)
            }
        })
    }
}