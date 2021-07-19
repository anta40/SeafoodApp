package com.anta40.app.seafoodapp.util

import com.anta40.app.seafoodapp.model.Meal

interface FoodClickListener {
    fun onRowClicked(data: Meal)
}