package com.example.testgridlayout.model

import androidx.room.Entity

@Entity
data class Response (
    val data: Gif,
    val pagination: Pagination,
    val meta: Meta
)

data class Gif (
    val image: Images,
    val title: String,
    val rating: String,
    val username: String
)

data class Images(
    val original: Original
)

class Original (
    val height: String,
    val width: String,
    val url: String
)

data class Pagination (
    val total_count: Int,
    val count: Int,
    val offset: Int
)

data class Meta (
    val status: String,
    val msg: String,
    val response_id: String
)

data class Result (val items: List<Response>)