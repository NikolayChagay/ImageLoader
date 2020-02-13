package com.example.testgridlayout.data.api

import android.app.Application
import io.reactivex.subjects.PublishSubject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Provider {
    val API_KEY = "j7bgFaep2hyvJNJqEbc5xgFCB1tnZ97B"

    private val subject = PublishSubject.create<Unit>()

    private val apiService : ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("api.giphy.com/v1/gifs")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxRetryCallAdapterFactory.create())
            .build()

        return@lazy retrofit.create(ApiService::class.java)
    }

    lateinit var appInstance : Application

    fun provideRetrySubject() : PublishSubject<Unit> = subject

    fun provideApiService() : ApiService = apiService
}