package com.anta40.app.seafoodapp.model

import com.google.gson.annotations.SerializedName

data class Meal (
    @SerializedName("strMeal") val description: String,
    @SerializedName("strMealThumb") val thumbnailUrl: String,
    @SerializedName("idMeal") val id : Int
)

data class MealList (
    @SerializedName("meals") val meals : List<Meal>
)
