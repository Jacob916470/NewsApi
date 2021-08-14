package com.jacob.newsapi.presentation.login.viewModel

import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jacob.newsapi.data.local.dataBase.NewsRoomDataBase
import com.jacob.newsapi.data.local.entities.User
import com.jacob.newsapi.data.local.repositories.UserRepository
import com.jacob.newsapi.presentation.core.base.BaseViewModel
import com.jacob.newsapi.presentation.core.callBack.ResultCallBack
import com.jacob.newsapi.presentation.login.view.LoginFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    newsRoomDataBase: NewsRoomDataBase,
    private val resultCallBack: ResultCallBack<User>
):BaseViewModel() {
    /** Se crean variables para poder obterner la información que ingrese el usuario*/
    val txtEmailLogin = ObservableField("")
    val txtPasswordLogin = ObservableField("")

    private val userRepository = UserRepository(newsRoomDataBase.userDao())

    /** Se crea funcion para poder acceder a la validación de datos*/
    fun getLogin(){
        validateLogin()
    }

    private fun validateLogin() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val user = userRepository.getLogin(
                email = txtEmailLogin.get().toString(),password = txtPasswordLogin.get().toString()
            )
            withContext(Dispatchers.Main){
                if (user != null){
                    resultCallBack.onSuccess(user)
                }else {
                    resultCallBack.onError("E-mail or password inccorect")
                }
            }
        }
    }
}