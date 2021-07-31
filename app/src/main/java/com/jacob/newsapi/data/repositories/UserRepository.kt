package com.jacob.newsapi.data.repositories

import com.jacob.newsapi.data.dao.UserDao
import com.jacob.newsapi.data.entities.User

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun insertUser(user:User): Long = userDao.insertUser(user)

    suspend fun getUserName(nameUser: String) = userDao.getUserName(nameUser = nameUser)

}