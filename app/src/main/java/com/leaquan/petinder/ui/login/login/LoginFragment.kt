package com.leaquan.petinder.ui.login.login

import androidx.lifecycle.ViewModelProvider
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentLoginBinding
import com.leaquan.petinder.util.view_model.kodeinViewModel
import com.leaquan.petinder.util.extension.WTF
import com.leaquan.petinder.util.text.gradientText
import com.leaquan.petinder.util.view_model.ViewModelFactory

class LoginFragment : BaseFragmentMVVM<FragmentLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by kodeinViewModel()

    override fun inflateLayout(): Int = R.layout.fragment_login



    override fun setUp() {
        binding.tvForgotPassword.gradientText()
        WTF(viewModel.paymentInforModel)
    }

    override fun setUpObserver() {
    }
}