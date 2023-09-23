package com.example.vvviewww

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adapter(val context: Context,val articles: List<ArticleX>):
    RecyclerView.Adapter<adapter.myviewholder>() {
     class myviewholder( itemView: View) : RecyclerView.ViewHolder(itemView) {
         var newsimage = itemView.findViewById<ImageView>(R.id.imageView)
         var newstitle =  itemView.findViewById<TextView>(R.id.textView2)
         var newsbody = itemView.findViewById<TextView>(R.id.textView3)
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.itemview,parent,false)
        return myviewholder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
       val article = articles[position]
        holder.newstitle.text = article.title
        holder.newsbody.text = article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsimage)
        holder.itemView.setOnClickListener {
            Toast.makeText(context,article.title,Toast.LENGTH_SHORT).show()
            val intent = Intent(context,MainActivity2::class.java)
            intent.putExtra("url",article.url)
            context.startActivity(intent)
        }

    }
}