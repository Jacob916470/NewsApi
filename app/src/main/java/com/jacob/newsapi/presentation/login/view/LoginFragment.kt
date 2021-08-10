package com.jacob.newsapi.presentation.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jacob.newsapi.R
import com.jacob.newsapi.data.local.dataBase.NewsRoomDataBase
import com.jacob.newsapi.data.local.entities.User
import com.jacob.newsapi.databinding.FragmentLoginBinding
import com.jacob.newsapi.presentation.core.callBack.ResultCallBack
import com.jacob.newsapi.presentation.login.viewModel.LoginViewModel
import com.jacob.newsapi.presentation.login.viewModel.LoginViewModelFactory

class LoginFragment: Fragment(), ResultCallBack<User> {

    private var fragmentLoginBinding: FragmentLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        fragmentLoginBinding?.loginViewModel =
            ViewModelProvider(
                this,
                LoginViewModelFactory(
                    newsRoomDataBase = NewsRoomDataBase.getDataBase(requireContext()),
                    resultCallBack = this
                )
            ).get(LoginViewModel::class.java)

        return fragmentLoginBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding?.btnSignUp?.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    override fun onSuccess(type: User) {
        Toast.makeText(requireContext(), "Welcome ${type.name}", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_loginFragment_to_pruebaFragment)
    }

    override fun onError(message: String, type: User?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}