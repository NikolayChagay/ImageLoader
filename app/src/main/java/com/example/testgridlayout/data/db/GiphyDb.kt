package com.example.testgridlayout.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testgridlayout.domain.model.GiphyImages

@Database( entities = [GiphyImages::class], version = 1, exportSchema = false)
abstract class GiphyDb : RoomDatabase() {

    abstract fun imagesDAO(): GiphyImagesDao

    companion object {
        var INSTANCE: GiphyDb? = null

        fun getAppDataBase(context: Context): GiphyDb? {
            if (INSTANCE == null){
                synchronized(GiphyDb::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, GiphyDb::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}