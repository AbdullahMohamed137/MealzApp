package com.example.mealzapp.data.remoteDS

import com.example.mealzapp.domain.model.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getMeals() : CategoryResponse
}