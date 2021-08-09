package com.jacob.newsapi.data.local.repositories

import com.jacob.newsapi.data.local.dao.UserDao
import com.jacob.newsapi.data.local.entities.User

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun insertUser(user:User): Long = userDao.insertUser(user)

    suspend fun getUserName(nameUser: String) = userDao.getUserName(nameUser = nameUser)

    /** Se crea función en la cual mandaremos a llamar nuestra Query en en la cual nos retornara un "email" y un "password"*/
    suspend fun getLogin(email: String, password: String): User?{
        return userDao.getLogin(email,password)
    }

}