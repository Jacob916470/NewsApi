package com.jacob.newsapi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jacob.newsapi.data.entities.User

@Dao
interface UserDao {

    @Query("Select * From user")
    suspend fun getUser(): List<User>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:User): Long

    @Query("SELECT COUNT(*) FROM user WHERE name = :nameUser")
    suspend fun getUserName(nameUser: String): Int

}