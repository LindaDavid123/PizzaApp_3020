package com.example.pizzaapp_3020.client

import android.telecom.Call
import com.example.pizzaapp_3020.response.account.LoginResponse
import com.example.pizzaapp_3020.response.food.FoodResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("food")
    fun getFood(): retrofit2.Call<ArrayList<FoodResponse>>

    @FormUrlEncoded
    @POST("account")
    fun postLogin(
        @Field("username") username:String,
        @Field("password") password:String,
    ): retrofit2.Call<LoginResponse>
}