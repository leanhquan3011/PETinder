package com.leaquan.petinder.ui.check_in.register

import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentRegisterBinding
import com.leaquan.petinder.util.view_model.kodeinViewModel

class RegisterFragment : BaseFragmentMVVM<FragmentRegisterBinding, RegisterViewModel>() {

    override fun inflateLayout(): Int = R.layout.fragment_register

    override val viewModel: RegisterViewModel by kodeinViewModel()

    override fun setUp() {

    }

    override fun setUpObserver() {

    }

}