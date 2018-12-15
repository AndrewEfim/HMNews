package com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news

import android.graphics.drawable.DrawableContainer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.domain.entity.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_item_news.view.*
import kotlin.collections.ArrayList


class MyNewsAdapter() : RecyclerView.Adapter<MyNewsAdapter.MyViewHolder>() {

    internal var mNews: ArrayList<News> = ArrayList()
    private lateinit var listner: (News) -> Unit

    interface OnItemClickListner {
        fun onItemClick(news: News)
    }

    fun setmNews(news: List<News>) {
        this.mNews = news as ArrayList<News>

        notifyDataSetChanged()

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal lateinit var newsTitle: TextView
        internal lateinit var newsArticle: TextView
        internal lateinit var newsImageURL: ImageView

        init {
            newsTitle = itemView.findViewById(R.id.mainTitleNewsItem)
            newsImageURL = itemView.findViewById(R.id.imageNewsItem)
        }

        fun bind(news: News) {
            val drawable = DrawableContainer()
             itemView.mainTitleNewsItem.text = news.title
            Picasso.get().load(news.imageurl).into(itemView.imageNewsItem)
            newsTitle.text = news.title//primer 1
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_news, parent, false)
        return MyViewHolder(view)
    }

    fun setOnItemClickListner(l: (News) -> Unit) {
        this.listner = l
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mNews[position])
        holder.itemView.setOnClickListener { listner(mNews.get(position)) }
    }

    override fun getItemCount(): Int {
        return mNews.size
    }
}
