package com.showtime.model


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class Series(var poster_path: String, var popularity: Int, var id: Int, var overview: String?, var first_air_date: String, var name: String, var original_name: String,  var release_date: String) : IModel {

    override fun getSeries(listener: OnDataListener) {

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.themoviedb.org/3/")
                .build()

        val client = retrofit.create(MovieDBApiInterface::class.java)
        val responseCall = client.getAllSeries("835003cab26ff0669db7cbcd0de43a6a", "pt_BR", "popularity.desc", 1)

        responseCall.enqueue(object : Callback<AllSeriesResponse> {
            override fun onResponse(call: Call<AllSeriesResponse>?, response: Response<AllSeriesResponse>?) {
                listener.onSuccess(response!!.body().results)
            }

            override fun onFailure(call: Call<AllSeriesResponse>?, t: Throwable?) {
                listener.onFailure(t!!.message.toString())
            }
        })
    }
}
