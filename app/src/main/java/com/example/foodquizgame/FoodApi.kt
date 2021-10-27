package com.example.foodquizgame

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodApi {
    @GET("{foodType}")
    fun getFood(@Path("foodType") foodType:String ): Call<Food>
}