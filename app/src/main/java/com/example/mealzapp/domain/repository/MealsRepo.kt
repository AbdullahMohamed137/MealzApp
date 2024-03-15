package com.example.mealzapp.domain.repository

import com.example.mealzapp.domain.model.CategoryResponse

interface MealsRepo {
    suspend fun getMealsFromRemote() : CategoryResponse
}