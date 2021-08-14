package com.jacob.newsapi.presentation.singUp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.jacob.newsapi.R
import com.jacob.newsapi.data.local.dataBase.NewsRoomDataBase
import com.jacob.newsapi.databinding.FragmentSignUpBinding
import com.jacob.newsapi.presentation.core.callBack.ResultCallBack
import com.jacob.newsapi.presentation.singUp.viewModel.SignUpViewModel
import com.jacob.newsapi.presentation.singUp.viewModel.SignUpViewModelFactory

class SignUpFragment : Fragment(), View.OnClickListener, ResultCallBack<String> {

    private var fragmentSignUpBinding: FragmentSignUpBinding? = null
    private val ref: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sign_up,
            container,
            false
        )
        fragmentSignUpBinding?.signUpViewModel =
            ViewModelProvider(
                this,
                SignUpViewModelFactory(
                    newsRoomDataBase = NewsRoomDataBase.getDataBase(requireContext()),
                    this
                )
            ).get(SignUpViewModel::class.java)

        return fragmentSignUpBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSignUpBinding?.btnSave?.setOnClickListener(this)
        fragmentSignUpBinding?.btnCancel?.setOnClickListener(this)
    }

    private fun saveUser() {
        fragmentSignUpBinding?.signUpViewModel?.saveUser()
    }

    private fun dismiss() {
        findNavController().navigateUp()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSave -> {
                saveUser()
            }
            R.id.btnCancel -> {
                dismiss()
            }
        }
    }

    override fun onSuccess(type: String) {
        Toast.makeText(requireContext(), "Bienvenido $type", Toast.LENGTH_SHORT).show()
        dismiss()
    }

    override fun onError(message: String, type: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}