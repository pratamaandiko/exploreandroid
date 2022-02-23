package com.example.submissionprogram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFakultasAdapter(private val listFakultas: ArrayList<Fakultas>) : RecyclerView.Adapter<ListFakultasAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView){
        var tvNameFakultas: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetailFakultas: TextView = itemView.findViewById(R.id.tv_item_detail)
        var ivFotoFakultas: ImageView = itemView.findViewById(R.id.img_item_fakultas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ListViewHolder(view)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listFakultas[position]
        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.ivFotoFakultas)
        holder.tvNameFakultas.text = hero.name
        holder.tvDetailFakultas.text = hero.detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFakultas[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listFakultas.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Fakultas)
    }

}