package com.example.testgridlayout.presention.recycler

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testgridlayout.R
import com.example.testgridlayout.domain.model.GiphyImages
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.big_card.view.*
import kotlinx.android.synthetic.main.small_card.*
import kotlinx.android.synthetic.main.small_card.view.*

internal class RecyclerAdapter( private val listImage: ArrayList<GiphyImages>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return listImage.get(position).viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View

        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.small_card, parent, false)
            return ViewHolderSmall(view)
        }

        view = layoutInflater.inflate(R.layout.big_card, parent, false)
        return ViewHolderBig(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: GiphyImages = listImage.get(position)

        if (item.viewType == 0) {
            // small
            val viewHolderSmall: ViewHolderSmall = holder as ViewHolderSmall
            viewHolderSmall.bindItem(item)
        } else {
            // big
            val viewHolderBig: ViewHolderBig = holder as ViewHolderBig
            viewHolderBig.bindItem(item)
        }
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    internal inner class ViewHolderSmall(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: GiphyImages) {
            Picasso
                .get()
                .load(item.url)
                .fit()
                .centerCrop()
                .into(itemView.ivLeft)
            itemView.tvTitleLeft.text = item.title


            Picasso
                .get()
                .load(item.url)
                .fit()
                .centerCrop()
                .into(itemView.ivRight)
            itemView.tvTitleRight.text = item.title
        }
    }

    internal inner class ViewHolderBig(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: GiphyImages) {
            Picasso
                .get()
                .load(item.url)
                .fit()
                .centerCrop()
                .into(itemView.ivImage)
            itemView.tvTitle.text = item.title
            itemView.tvUser.text = item.username
            itemView.tvRating.text = item.rating
        }
    }
}