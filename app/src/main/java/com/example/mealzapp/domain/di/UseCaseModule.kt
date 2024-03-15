package com.example.mealzapp.domain.di

import com.example.mealzapp.domain.repository.MealsRepo
import com.example.mealzapp.domain.useCase.GetMealz
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(mealsRepo: MealsRepo) : GetMealz{
        return GetMealz(mealsRepo)
    }
}