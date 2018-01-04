package com.example.rafaelaaraujo.kotlinsample.model

/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */
data class PostsResult(
        val graphql: Graphql
)

data class MediaNode(
        val id: String,
        val display_url: String,
        val thumbnail_src: String,
        val edge_media_to_caption: EdgesList<TextNode>,
        val edge_liked_by: EdgeLikedBy
)

data class TextNode(
        val text: String
)

data class EdgeTo<T>(
        val node: T
)

data class EdgesList<T>(
        val edges: List<EdgeTo<T>>
)

data class EdgeLikedBy(
        val count: Int
)

data class Hashtag(
        val name: String,
        val edge_hashtag_to_media: EdgesList<MediaNode>,
        val edge_hashtag_to_top_posts: EdgesList<MediaNode>
)

data class Graphql(
        val hashtag: Hashtag
)
