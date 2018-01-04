package com.example.rafaelaaraujo.kotlinsample.home

import com.example.rafaelaaraujo.kotlinsample.connection.SampleService
import com.example.rafaelaaraujo.kotlinsample.model.Hashtag
import com.example.rafaelaaraujo.kotlinsample.model.InstagramPost
import io.reactivex.android.schedulers.AndroidSchedulers
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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrievePosts ->
                            view.hideLoading()
                            view.showPosts(transformPostsResultToModel(retrievePosts.graphql.hashtag))
                        },
                        {
                            view.hideLoading()
                            view.showErrorMessage()
                        }
                )
    }

    fun transformPostsResultToModel(hashtag: Hashtag) : ArrayList<InstagramPost> {
        var list = ArrayList<InstagramPost>()

        hashtag.edge_hashtag_to_top_posts.edges.forEach({ edgeToMediaNode ->
            list.add(InstagramPost(edgeToMediaNode.node.display_url,
                    edgeToMediaNode.node.edge_media_to_caption.edges.firstOrNull()?.node?.text,
                    edgeToMediaNode.node.edge_liked_by.count))
        })

        hashtag.edge_hashtag_to_media.edges.forEach({ edgeToMediaNode ->
            list.add(InstagramPost(edgeToMediaNode.node.display_url,
                    edgeToMediaNode.node.edge_media_to_caption.edges.firstOrNull()?.node?.text,
                    edgeToMediaNode.node.edge_liked_by.count))
        })

        return list
    }
}