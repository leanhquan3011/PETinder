package com.leaquan.petinder.ui.check_in.login

import androidx.core.os.bundleOf
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentLoginBinding
import com.leaquan.petinder.ui.check_in.forgot_password.ForgotPasswordFragment
import com.leaquan.petinder.ui.check_in.register.RegisterFragment
import com.leaquan.petinder.ui.custom_view.ToastPET
import com.leaquan.petinder.util.Toast
import com.leaquan.petinder.util.Toast.Companion.ERROR
import com.leaquan.petinder.util.Toast.Companion.LONG
import com.leaquan.petinder.util.Toast.Companion.SUCCESS
import com.leaquan.petinder.util.Toast.Companion.WARNING
import com.leaquan.petinder.util.view_extension.transformation
import com.leaquan.petinder.util.view_model.kodeinViewModel
import com.leaquan.petinder.util.extension.WTF
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.pushFragment
import com.leaquan.petinder.util.text.gradientText

class LoginFragment : BaseFragmentMVVM<FragmentLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by kodeinViewModel()

    override fun inflateLayout(): Int = R.layout.fragment_login

    companion object {
        fun instance(from : String) : LoginFragment {
            return LoginFragment().apply {
                arguments = bundleOf().apply {
                    putString(FROM, from)
                }
            }
        }
        val TAG = LoginFragment::class.simpleName
        const val FROM = "from"
    }

    private val from by lazy { arguments?.getString(FROM) }

    override fun setUp() {
        with(binding) {

            tvForgotPassword.gradientText()

            tvForgotPassword.onClick {
                activity?.pushFragment(
                    ForgotPasswordFragment.instance(TAG!!)
                )
            }

            ivShowPassword.onClick {
                edtPassword.transformation(ivShowPassword)
            }

            btnLogin.onClick {
              //  ToastPET(activity).makeText(activity,  "Đã chia sẽ cho thầy!", LONG, SUCCESS)?.show()
            }

            btnRegister.onClick {
                activity?.pushFragment(
                    RegisterFragment.instance(TAG!!)
                )
            }

            layoutSocial.btnFacebook.onClick {
                ToastPET(activity).makeText(activity,  "Đã chia sẽ cho thầy!", LONG, SUCCESS)?.show()
            }

            layoutSocial.btnGoogle.onClick {
                ToastPET(activity).makeText(activity,  "Đã chia sẽ cho thầy!", LONG, WARNING)?.show()
            }

            layoutSocial.btnPhone.onClick {
                ToastPET(activity).makeText(activity,  "Đã chia sẽ cho thầy!", LONG, ERROR)?.show()
            }

            WTF(from + activity?.supportFragmentManager?.backStackEntryCount.toString())
        }
    }

    override fun setUpObserver() {
    }
}