package com.jacob.newsapi.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jacob.newsapi.data.dao.UserDao
import com.jacob.newsapi.data.entities.User

@Database(
    entities = [
        User::class
    ],
    version = 1
)
abstract class NewsRoomDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: NewsRoomDataBase? = null

        fun getDataBase(context: Context): NewsRoomDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    NewsRoomDataBase::class.java,
                    "news_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}