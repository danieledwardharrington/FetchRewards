package com.example.fetchrewards.remote

import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FetchService {

    @GET("/hiring.json")
    fun getItems(): Observable<List<ItemModel>>

    companion object {
        fun create(): FetchService {
            val client = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://fetch-hiring.s3.amazonaws.com")
                .build()

            return retrofit.create(FetchService::class.java)
        }
    }
}