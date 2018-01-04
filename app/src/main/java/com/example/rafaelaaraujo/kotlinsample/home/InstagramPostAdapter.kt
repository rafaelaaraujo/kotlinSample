package com.example.rafaelaaraujo.kotlinsample.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rafaelaaraujo.kotlinsample.R
import com.example.rafaelaaraujo.kotlinsample.common.loadUrl
import com.example.rafaelaaraujo.kotlinsample.model.InstagramPost
import kotlinx.android.synthetic.main.instagram_post.view.*

/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */
class InstagramPostAdapter(
        private val clickListener: (InstagramPost) -> Unit):
        RecyclerView.Adapter<InstagramPostAdapter.ViewHolder>(){

    var instagramPosts = ArrayList<InstagramPost>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(instagramPosts[position], clickListener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.instagram_post, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() =  instagramPosts.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(instagramPost: InstagramPost, listener: (InstagramPost) -> Unit) = with(itemView) {
            instagramPostLikes.text = context.getString(R.string.likes_text, instagramPost.likes)
            instagramPostDescription.text = instagramPost.text
            instagramPostImage.loadUrl(instagramPost.display_url)

            setOnClickListener { listener.invoke(instagramPost) }
        }
    }

}