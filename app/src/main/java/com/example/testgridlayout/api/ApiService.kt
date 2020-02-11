package com.example.testgridlayout.api

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET ("/trending")
    fun trending(): Observable<Response> // TODO


    // http://api.giphy.com/v1/gifs/search?q=beer&api_key=j7bgFaep2hyvJNJqEbc5xgFCB1tnZ97B&limit=5
    @GET("/search")
    fun search(@Query("q") query: String): Observable<Response>

    companion object Factory {
        val API_KEY = "j7bgFaep2hyvJNJqEbc5xgFCB1tnZ97B"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("api.giphy.com/v1/gifs")
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    data class Response (
        val data: List<Gif>,
        val pagination: List<Pagination>,
        val meta: List<Meta>
    )

    data class Gif (
        val image: List<Images>,
        val title: String,
        val rating: String,
        val username: String
    )

    data class Images(
        val original: List<Original>
    )

    class Original (
        val height: String,
        val width: String,
        val url: String
    )

    data class Pagination (
        val total_count: Int,
        val count: Int,
        val offset: Int
    )

    data class Meta (
        val status: String,
        val msg: String,
        val response_id: String
    )

}