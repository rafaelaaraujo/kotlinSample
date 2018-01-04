package com.example.rafaelaaraujo.kotlinsample.connection

import com.example.rafaelaaraujo.kotlinsample.model.PostsResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface InstagramApi {

    @GET("/explore/tags/{tag}/?__a=1")
    fun getPostsFromTag(@Path("tag") tag:String) : Observable<PostsResult>
    // TODO change to RequestObservable<> for unit tests (rx adapter implementation required)


}