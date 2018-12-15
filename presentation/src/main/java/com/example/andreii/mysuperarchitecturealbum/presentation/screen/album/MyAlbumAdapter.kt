package com.example.andreii.mysuperarchitecturealbum.presentation.screen.album

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.domain.entity.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_item.view.*
import java.util.*
import kotlin.collections.ArrayList


class MyAlbumAdapter() : RecyclerView.Adapter<MyAlbumAdapter.MyViewHolder>() {
    private val serchResult: ArrayList<Album> = ArrayList()
    private var albumList: ArrayList<Album> = ArrayList()
    internal var mAlbums: ArrayList<Album> = ArrayList()

    private lateinit var listner: (Album) -> Unit

    interface OnItemClickListner {
        fun onItemClick(album: Album)
    }

    fun setmAlbums(albums: List<Album>) {
        this.mAlbums = albums as ArrayList<Album>
        mAlbums.sortBy { selector(it) }
        notifyDataSetChanged()

    }

    fun selector(a: Album): String = a.year

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var albumName: TextView
        internal var albumYear: TextView
        internal var albumImageURL: ImageView

        init {
            albumName = itemView.findViewById(R.id.nameAlbumItem)//primer 1
            albumYear = itemView.findViewById(R.id.yearAlbumItem)
            albumImageURL = itemView.findViewById(R.id.imageAlbumItem)
        }

        fun bind(album: Album) {
            val drawable = DrawableContainer()
            itemView.nameAlbumItem.text = album.name
            itemView.yearAlbumItem.text = album.year
            Picasso.get().load(album.imageurl).into(itemView.imageAlbumItem)
            albumName.text = album.name//primer 1
            albumYear.text = album.year

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return MyViewHolder(view)
    }

    fun setOnItemClickListner(l: (Album) -> Unit) {
        this.listner = l
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mAlbums[position])
        holder.itemView.setOnClickListener { listner(mAlbums.get(position)) }

    }

    override fun getItemCount(): Int {
        return mAlbums.size
    }

    @BindingAdapter("app:URl")
    fun imageAdapter(imageView: ImageView, url: String) {
        Picasso.get().load(url).into(imageView)

    }

    fun loadImage(imageview: ImageView, url: String?, placeHolder: Drawable) {
        if (url == null) {
            imageview.setImageDrawable(placeHolder)
        } else {
            Picasso.get().load(url).into(imageview)
        }
    }

}
