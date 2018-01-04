package com.example.rafaelaaraujo.kotlinsample.connection

import com.example.rafaelaaraujo.kotlinsample.model.PostsResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
class InstagramPostService {

    val SERVER_ADDRESS = "https://www.instagram.com/"

    private val instagramApi: InstagramApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(SERVER_ADDRESS)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        instagramApi = retrofit.create(InstagramApi::class.java)
    }

    fun getPosts(tag:String): Observable<PostsResult> =
            instagramApi.getPostsFromTag(tag)

}