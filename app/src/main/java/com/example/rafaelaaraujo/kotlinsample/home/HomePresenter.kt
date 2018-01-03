package com.example.rafaelaaraujo.kotlinsample.home

import com.example.rafaelaaraujo.kotlinsample.connection.SampleService
import io.reactivex.schedulers.Schedulers


/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */
class HomePresenter(
        private val view: HomeContract.View,
        private val service: SampleService = SampleService()) : HomeContract.Presenter {

    init {
        view.presenter = this
    }

    override fun loadPosts(tag: String) {
        view.showLoading()
        service.getPosts(tag)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { retrievePosts ->
                            view.showPosts(retrievePosts.graphql.hashtag.edge_hashtag_to_media.edges)
                        },
                        {
                            view.showErrorMessage()
                        }
                )
    }
}