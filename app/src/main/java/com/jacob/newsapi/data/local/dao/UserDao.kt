package com.jacob.newsapi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jacob.newsapi.data.local.entities.User

@Dao
interface UserDao {

    @Query("Select * From user")
    suspend fun getUser(): List<User>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT COUNT(*) FROM user WHERE name = :nameUser")
    suspend fun getUserName(nameUser: String): Int

    /** Se crea Query en la cual le asignaremos la acción de mandar a comparar los datos que recibamos del usuario*/
    @Query("SELECT * FROM user WHERE mail = :email and password = :password ")
    fun getLogin(email: String, password: String): User?

}