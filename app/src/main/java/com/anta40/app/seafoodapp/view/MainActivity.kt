package com.anta40.app.seafoodapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anta40.app.seafoodapp.adapter.FoodAdapter
import com.anta40.app.seafoodapp.databinding.ActivityMainBinding
import com.anta40.app.seafoodapp.model.Meal
import com.anta40.app.seafoodapp.util.FoodClickListener
import com.anta40.app.seafoodapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), FoodClickListener {

    private val vm: MainActivityViewModel by lazy { MainActivityViewModel() }
    private lateinit var binding: ActivityMainBinding;
    private  lateinit var recyclerview_food_list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerview_food_list = binding.recviewFoodList

        vm.getData()
        observe()
    }

    private fun observe() {
        vm.seafoodListLiveData.observe(this) {
            if (it.meals.isEmpty()){
                Toast.makeText(applicationContext, "Data kosong", Toast.LENGTH_SHORT).show()
            }
            else  {
                val food_adapter = FoodAdapter(applicationContext, it.meals, this)
                recyclerview_food_list.layoutManager = LinearLayoutManager(applicationContext,
                    LinearLayoutManager.VERTICAL, false)
                recyclerview_food_list.adapter = food_adapter
            }
        }
    }

    override fun onRowClicked(data: Meal) {
        val newIntent = Intent(this@MainActivity, DetailActivity::class.java )
        intent.putExtra("meal_id", data.id)
        startActivity(intent)
    }
}