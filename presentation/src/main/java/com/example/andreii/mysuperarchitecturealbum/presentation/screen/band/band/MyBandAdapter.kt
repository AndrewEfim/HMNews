package com.example.andreii.mysuperarchitecturealbum.presentation.screen.band.band

import android.graphics.drawable.DrawableContainer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.domain.entity.Band
import kotlinx.android.synthetic.main.fragment_bands_item.view.*


class MyBandAdapter() : RecyclerView.Adapter<MyBandAdapter.MyViewHolder>() {


    internal var mBands: ArrayList<Band> = ArrayList()
    private lateinit var listner: (Band) -> Unit

    interface OnItemClickListner {
        fun onItemClick(band: Band)
    }

    fun setmBands(band: List<Band>) {
        this.mBands = band as ArrayList<Band>
        mBands.sortBy { selector(it) }
        notifyDataSetChanged()

    }

    fun selector(b: Band): String = b.name

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal lateinit var bandName: TextView

        init {
            bandName = itemView.findViewById(R.id.bandName_Bands_Item)//itemView.findViewById(R.id.nameAlbumItem)//primer 1
        }

        fun bind(band: Band) {
            val drawable = DrawableContainer()
            itemView.bandName_Bands_Item.text = band.name
            bandName.text = band.name//primer 1
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_bands_item, parent, false)
        return MyViewHolder(view)
    }

    fun setOnItemClickListner(l: (Band) -> Unit) {
        this.listner = l
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mBands[position])

        holder.itemView.setOnClickListener { listner(mBands.get(position)) }

    }

    override fun getItemCount(): Int {
        return mBands.size
    }

}
