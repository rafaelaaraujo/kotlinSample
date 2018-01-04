package com.example.rafaelaaraujo.kotlinsample

import com.example.rafaelaaraujo.kotlinsample.connection.InstagramPostService
import com.example.rafaelaaraujo.kotlinsample.connection.RequestObservable
import com.example.rafaelaaraujo.kotlinsample.home.HomeContract
import com.example.rafaelaaraujo.kotlinsample.home.HomePresenter
import com.example.rafaelaaraujo.kotlinsample.model.*
import com.nhaarman.mockito_kotlin.any
import io.reactivex.Observable
import org.mockito.Mockito.*
import org.junit.Test

import org.mockito.BDDMockito.given

class HomePresenterUnitTest {

    val homeViewMock: HomeContract.View = mock(HomeContract.View::class.java)
    //val schedulersFactoryStub: SchedulersFactory = mock(SchedulersFactory::class.java)
    val instagramPostServiceStub = mock(InstagramPostService::class.java)

    val objectUnderTest = HomePresenter(homeViewMock, instagramPostServiceStub)


    @Test
    fun testLoadPosts() {
        //given
        given(instagramPostServiceStub.getPosts(any())).willReturn(Observable.just(mockedPostsResult()))
        //when
        objectUnderTest.loadPosts("whatever")
        //then
        verify(homeViewMock).showPosts(mockedInstagramPosts())
    }

    private fun mockedInstagramPosts(): ArrayList<InstagramPost> {
        return arrayListOf<InstagramPost>(InstagramPost("display_url", "text", 123),
                InstagramPost("display_url", "text", 123))
    }

    private fun mockedPostsResult(): PostsResult? {
        val captionEdges = ArrayList<EdgeTo<TextNode>>()
        captionEdges.add(EdgeTo(TextNode("text")))
        val edgeToCaption = EdgesList<TextNode>(captionEdges)

        val mediaEdges = ArrayList<EdgeTo<MediaNode>>()
        mediaEdges.add(EdgeTo(MediaNode("display_url", "thumbnail_src",
                edgeToCaption, EdgeLikedBy(123))))
        val edgeToMedia = EdgesList<MediaNode>(mediaEdges)

        return PostsResult(Graphql(Hashtag("dog", edgeToMedia, edgeToMedia)))
    }
}
