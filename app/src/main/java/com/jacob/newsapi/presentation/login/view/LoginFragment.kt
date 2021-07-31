package com.jacob.newsapi.presentation.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jacob.newsapi.R
import com.jacob.newsapi.databinding.FragmentLoginBinding
import com.jacob.newsapi.presentation.login.viewModel.LoginViewModel

class LoginFragment: Fragment(), View.OnClickListener {

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
                this
            ).get(LoginViewModel::class.java)

        return fragmentLoginBinding?.root
    }

    fun login(){
        findNavController().navigate(R.id.action_loginFragment_to_newsActivity)
    }

    fun signUp(){
        findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding?.btnSignUp?.setOnClickListener(this)
        fragmentLoginBinding?.btnLogin?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnLogin ->{
               login()
            }
            R.id.btnSignUp ->{
                signUp()
            }
        }
    }
}