package com.jacob.newsapi.presentation.singUp.viewModel

import androidx.databinding.ObservableField
import com.google.firebase.auth.FirebaseAuth
import com.jacob.newsapi.data.local.dataBase.NewsRoomDataBase
import com.jacob.newsapi.data.local.entities.User
import com.jacob.newsapi.data.local.repositories.UserRepository
import com.jacob.newsapi.presentation.core.base.BaseViewModel
import com.jacob.newsapi.presentation.core.callBack.ResultCallBack
import com.jacob.newsapi.presentation.utils.FieldValidation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel(
    private val newsRoomDataBase: NewsRoomDataBase,
    private val resultCallBack: ResultCallBack<String>
) : BaseViewModel() {

    private val userRepository = UserRepository(newsRoomDataBase.userDao())

    val txtName = ObservableField("")
    val txtEmail = ObservableField("")
    val txtPassword = ObservableField("")

    private fun inserUser() {
       job = CoroutineScope(Dispatchers.IO).launch {
            val rows = userRepository.insertUser(
                user = User(
                    name = txtName.get().toString(),
                    mail = txtEmail.get().toString(),
                    password = txtPassword.get().toString()
                )
            )
            withContext(Dispatchers.Main) {
                if (rows > 0) {
                    resultCallBack.onSuccess(txtName.get().toString())
                } else {
                    resultCallBack.onError("No se pudo agregar usuario, inentelo de nuevo")
                }
            }
        }
    }

    fun saveUser() {
        when {
            txtName.get().toString().isEmpty() -> {
                resultCallBack.onError("Necesitamos saber tu NOMBRE")
            }
            txtEmail.get().toString().isEmpty() -> {
                resultCallBack.onError("Nececitamos saber tu E-mail")
            }
            txtPassword.get().toString().isEmpty() -> {
                resultCallBack.onError("Necesitas una contraseña para tu cuanta")
            }
            else -> {
                validateUser()
            }
        }
    }

    private fun validateUser() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val userCount = userRepository.getUserName(txtName.get().toString())

            withContext(Dispatchers.Main) {
                if (userCount == 0) {
                    validations()
                } else {
                    resultCallBack.onError("Ya existe ese NOMBRE")
                }
            }
        }
    }

    private fun validations() {
        if (FieldValidation.isPasswordSafe(paswword = txtPassword.get().toString()) &&
            FieldValidation.isPasswordLength(paswword = txtPassword.get().toString())
        ) {
            inserUser()
        } else {
            resultCallBack.onError(
                "Tu contraseña nececita tener por lo menos 8 a 16 caracteres, " +
                        "tener un numero y por lo menos un caracter especial"
            )
        }
    }
}