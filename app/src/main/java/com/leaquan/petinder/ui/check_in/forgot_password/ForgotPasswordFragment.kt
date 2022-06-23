package com.leaquan.petinder.ui.check_in.forgot_password

import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentForgotPasswordBinding
import com.leaquan.petinder.util.view_model.kodeinViewModel

class ForgotPasswordFragment : BaseFragmentMVVM<FragmentForgotPasswordBinding, ForgotPasswordViewModel>() {

    override fun inflateLayout(): Int = R.layout.fragment_forgot_password

    override val viewModel: ForgotPasswordViewModel by kodeinViewModel()

    override fun setUp() {
    }

    override fun setUpObserver() {
    }
}