package com.example.restapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restapi.pojo.Photo
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.photos_list_item.view.*



class AdapterPhoto (var mdataSetP: List<Photo>): RecyclerView.Adapter<AdapterPhoto.photoHolder>(){

    class photoHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTv= itemView.titleTV
        val photoTv= itemView.photoTV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): photoHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.photos_list_item, parent, false)
        return AdapterPhoto.photoHolder(view)
    }

    override fun getItemCount(): Int {
        return mdataSetP.size
    }

    override fun onBindViewHolder(holder: photoHolder, position: Int) {
        val photo =  mdataSetP[position]

        val titletv ="Title: ${photo.title}"

        holder.titleTv.text = titletv
        Picasso.get()
            .load(mdataSetP[position].url)
            .into(holder.photoTv)

        //holder.photoTv.te = email

    }


}