package com.showtime.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBApiInterface{
//    @GET("movie/top_rated")
//    abstract fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MoviesResponse>
//
    @GET("search/tv/")
    fun searchSeries(@Query("api_key") apiKey: String, @Query("language") language: String, @Query("query") query: String ): Call<AllSeriesResponse>

    @GET("discover/tv")
    fun getAllSeries(@Query("api_key") apiKey: String, @Query("language") language: String, @Query("sort_by") sort_by: String,@Query("page") page: Int ): Call<AllSeriesResponse>

}