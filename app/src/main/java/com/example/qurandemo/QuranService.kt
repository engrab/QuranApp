package com.example.qurandemo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//https://api.quran.com/api/v4/quran/verses/imlaei

const val BASE_URL = "https://api.quran.com/"

interface QuranService {

    @GET("api/v4/quran/verses/imlaei")
    fun getQuran(): Call<TopModel>
}

object MyService{
    val quranService:QuranService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        quranService = retrofit.create(QuranService::class.java)
    }
}