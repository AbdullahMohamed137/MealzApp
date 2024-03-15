package com.example.mealzapp.domain.di

import com.example.mealzapp.data.remoteDS.ApiService
import com.example.mealzapp.data.repository.MealsRepoImpl
import com.example.mealzapp.domain.repository.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService) : MealsRepo{
        return MealsRepoImpl(apiService)
    }
}