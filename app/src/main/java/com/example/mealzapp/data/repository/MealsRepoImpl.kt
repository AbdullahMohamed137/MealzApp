package com.example.mealzapp.data.repository

import com.example.mealzapp.data.remoteDS.ApiService
import com.example.mealzapp.domain.model.CategoryResponse
import com.example.mealzapp.domain.repository.MealsRepo
import javax.inject.Inject


// private val apiService : ApiService ----> class MealsRepoImpl depend on Interface ApiService

class MealsRepoImpl @Inject constructor(private val apiService: ApiService) : MealsRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}