package com.example.testgridlayout.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "images")
class GiphyImages (

    @PrimaryKey
    @SerializedName("url")
    val url: String,

    @SerializedName("title")
    val title: String?,

    @SerializedName("rating")
    val rating: String?,

    @SerializedName("username")
    val username: String?,

    @SerializedName("height")
    val height: String,

    @SerializedName ("width")
    val width: String,

    val viewType: Int
)