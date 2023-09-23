package com.example.vvviewww
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val Base_url = "https://newsapi.org/"
const val api_key = "af0ea2117aff4524bb5eed9250dd45c3"
interface Newsinterface {

    @GET("v2/top-headlines?apiKey=$api_key")
    fun getheadlines(@Query("country") country:String,@Query("page") page:Int):Call<newsobjects>
}
 object NewsService
 {
     val newsinstance: Newsinterface

     init {
         val retrofit = Retrofit.Builder()
             .baseUrl(Base_url)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
         newsinstance = retrofit.create(Newsinterface::class.java)
     }
 }

