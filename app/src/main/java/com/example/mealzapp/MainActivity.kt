package com.example.mealzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealzapp.Adapter.MealzAdapter
import com.example.mealzapp.presenter.viewModel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel : MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        if (supportActionBar != null) {
            supportActionBar?.hide()
        }


        viewModel.getMeals()
        lifecycleScope.launch {
            viewModel.categories.collect{
                it?.let {
                    if (!it.categories.isNullOrEmpty()){
                        val mealsAdapter : MealzAdapter = MealzAdapter(it.categories)
                        val rv : RecyclerView = findViewById(R.id.category_rv)
                        rv.adapter = mealsAdapter
                    }
                }
            }
        }

    }
}