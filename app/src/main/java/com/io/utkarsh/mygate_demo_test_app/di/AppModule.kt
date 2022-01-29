package com.io.utkarsh.mygate_demo_test_app.di

import com.io.utkarsh.mygate_demo_test_app.network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideUrl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideApiService(url: String):ApiInterface =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
}