package com.example.mealzapp.domain.useCase

import com.example.mealzapp.domain.repository.MealsRepo
import javax.inject.Inject

// useCase depend on repo
class GetMealz @Inject constructor(private val mealsRepo: MealsRepo){

    //operator--> علشان عندى كلاس واحد جواه فانكشن واحده فبدل منادى عليها لا انا هعملها وانادى ع الكلاس على طول
    //GetMealz()--> كده انا ناديت على الفانكشن
    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
}