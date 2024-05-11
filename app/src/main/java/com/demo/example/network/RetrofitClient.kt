package com.demo.example.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetrofitClient {

//    private const val BASE_URL = "https://reqres.in/"
//
//    private val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//    val apiService: ApiService = retrofit.create(ApiService::class.java)

    companion object {
        const val BASE_URL = "https://reqres.in/api/"
        //    private static Retrofit retrofit;
        private val builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        @JvmStatic
        fun <S> createService(serviceClass: Class<S>?): S {
            return retrofit.create(serviceClass)
        }
    }
}
