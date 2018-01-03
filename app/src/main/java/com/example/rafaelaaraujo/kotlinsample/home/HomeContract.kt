package com.example.rafaelaaraujo.kotlinsample.home

import com.example.rafaelaaraujo.kotlinsample.common.BaseView
import com.example.rafaelaaraujo.kotlinsample.model.Edge

/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */
class HomeContract{

    interface View : BaseView<Presenter> {

        fun showPosts(edges: List<Edge>)
    }

    interface Presenter {

        fun loadPosts(tag:String)
    }
}