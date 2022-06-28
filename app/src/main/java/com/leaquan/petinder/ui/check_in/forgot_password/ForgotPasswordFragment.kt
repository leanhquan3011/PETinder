package com.leaquan.petinder.ui.check_in.forgot_password

import androidx.core.os.bundleOf
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentForgotPasswordBinding
import com.leaquan.petinder.ui.check_in.login.LoginFragment.Companion.FROM
import com.leaquan.petinder.util.extension.WTF
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.pushFragment
import com.leaquan.petinder.util.view_model.kodeinViewModel

class ForgotPasswordFragment : BaseFragmentMVVM<FragmentForgotPasswordBinding, ForgotPasswordViewModel>() {

    override fun inflateLayout(): Int = R.layout.fragment_forgot_password

    override val viewModel: ForgotPasswordViewModel by kodeinViewModel()

    companion object {
        fun instance(from : String) : ForgotPasswordFragment {
            return ForgotPasswordFragment().apply {
                arguments = bundleOf().apply {
                    putString(FROM, from)
                }
            }
        }
    }

    private val from by lazy { arguments?.getString(FROM) }

    override fun setUp() {
        WTF(from + activity?.supportFragmentManager?.backStackEntryCount.toString())
        with(binding) {
            btnSend.onClick {
                activity?.supportFragmentManager?.popBackStack()
            }
        }
    }

    override fun setUpObserver() {
    }
    
}