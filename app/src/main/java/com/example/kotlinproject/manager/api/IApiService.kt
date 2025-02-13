package com.example.kotlinproject.manager.api

import android.telecom.Call
import com.example.kotlinproject.entity.CityResponse
import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path


interface IApiService {

    @GET(".")
    fun getAllCoffeeShop(
    ): Observable<List<CityResponse>>

    @GET("{city}")
    fun getCityCoffeeShop(
        @Path("city") city: String
    ): Observable<List<CityResponse>>
}