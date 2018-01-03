package com.example.rafaelaaraujo.kotlinsample.connection

import com.example.rafaelaaraujo.kotlinsample.model.PostsResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */


/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */


class SampleService {

    private val instagramApi: InstagramApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl( "https://www.instagram.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        instagramApi = retrofit.create(InstagramApi::class.java)
    }

    fun getPosts(tag:String): Observable<PostsResult> =
            instagramApi.getPostsFromTag(tag)

}