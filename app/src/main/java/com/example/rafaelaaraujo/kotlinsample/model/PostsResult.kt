package com.example.rafaelaaraujo.kotlinsample.model

/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */
data class PostsResult(
        val graphql: Graphql
)

data class Node (
    val display_url:String,
    val thumbnail_src:String
)

data class Edge(
        val node: Node
)

data class EdgeHashtagToMedia(
        val count: Int,
        val edges: List<Edge>
)


data class Hashtag(
        val name: String,
        val is_top_media_only: Boolean,
        val edge_hashtag_to_media: EdgeHashtagToMedia
)

data class Graphql(
        val hashtag: Hashtag
)

   


