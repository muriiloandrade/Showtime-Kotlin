package com.showtime.model

import retrofit2.Call
import retrofit2.http.*

interface ShowtimeApiInterface{
//    @GET("movie/top_rated")
//    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MoviesResponse>

    @POST("login")
    fun login(@Body loginUser: UserLogin): Call<UserLogin>

    @POST("register")
    fun addUser(@Body newUser: User): Call<User>

}