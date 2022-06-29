package com.leaquan.petinder.ui.check_in.register

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.os.bundleOf
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentRegisterBinding
import com.leaquan.petinder.ui.check_in.login.LoginFragment.Companion.FROM
import com.leaquan.petinder.util.type.Toast.Type
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.text.setLoginText
import com.leaquan.petinder.util.view_extension.transformation
import com.leaquan.petinder.util.view_model.kodeinViewModel

class RegisterFragment : BaseFragmentMVVM<FragmentRegisterBinding, RegisterViewModel>() {

    companion object {
        fun instance(from : String) : RegisterFragment {
            return RegisterFragment().apply {
                arguments = bundleOf().apply {
                    putString(FROM, from)
                }
            }
        }
    }

    private val from by lazy { arguments?.getString(FROM) }

    override fun inflateLayout(): Int = R.layout.fragment_register

    override val viewModel: RegisterViewModel by kodeinViewModel()

    override fun setUp() {
        with(binding) {

            ivShowPassword.onClick {
                edtPassword.transformation(it)
            }

            ivShowConfirmPassword.onClick {
                edtConfirmPassword.transformation(it)
            }

            tvHaveAccount.setLoginText(object : ClickableSpan() {
                override fun onClick(p0: View) {
                    activity?.supportFragmentManager?.popBackStack()
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false
                }
            })

            layoutSocial.btnFacebook.onClick {
                showShortToast("dung roif do mi", Type.WARNING)
            }

            layoutSocial.btnGoogle.onClick {
                showLongToast("cay ni thi hen xui", Type.ERROR)
            }

            layoutSocial.btnPhone.onClick {
                showSnackBar("vai cc")
            }
        }
    }

    override fun setUpObserver() {

    }

}