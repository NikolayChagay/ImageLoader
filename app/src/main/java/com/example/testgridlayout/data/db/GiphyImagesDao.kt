package com.example.testgridlayout.data.db

import androidx.room.Dao
import androidx.room.Query
import com.example.testgridlayout.domain.model.Images

@Dao
interface GiphyImagesDao {

    @Query("SELECT * FROM images")
    fun getAllImages() : List<Images>

    @Query ("DELETE FROM images")
    fun deleteAllImages()

}