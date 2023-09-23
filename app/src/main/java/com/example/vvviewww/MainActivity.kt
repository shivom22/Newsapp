package com.example.vvviewww

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var Adapter: adapter
    private var articles = mutableListOf<ArticleX>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newslist = findViewById<RecyclerView>(R.id.newslIST)
        Adapter = adapter(this@MainActivity,articles)
        newslist.adapter = Adapter
        val manager= StackLayoutManager(false,true,0.4f)
        newslist.layoutManager = manager
        getnews()
    }

    private fun getnews() {
       val news=  NewsService.newsinstance.getheadlines("in",1)
        news.enqueue(object :Callback<newsobjects>{
            override fun onResponse(call: Call<newsobjects>, response: Response<newsobjects>) {
               val news = response.body()
                if(news!=null){
                    Log.d("newsapp",news.toString())
                    articles.addAll(news.articles)
                    Adapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<newsobjects>, t: Throwable) {
                Log.d("newsapp" ,"Error in fetching news",t)
            }
        })
    }

}
