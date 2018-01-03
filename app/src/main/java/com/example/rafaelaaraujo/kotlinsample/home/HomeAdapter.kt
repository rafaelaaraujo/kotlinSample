package com.example.rafaelaaraujo.kotlinsample.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.rafaelaaraujo.kotlinsample.model.Edge

/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */
class HomeAdapter (
        private val hashtagList: List<Edge>,
        private val listener: (Edge) -> Unit):
        RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) = holder.bind(hashtagList[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
    }

    override fun getItemCount() =  hashtagList.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}