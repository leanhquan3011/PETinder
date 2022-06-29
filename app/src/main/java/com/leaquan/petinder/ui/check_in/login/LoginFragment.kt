package com.leaquan.petinder.ui.check_in.login

import android.os.Bundle
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentLoginBinding
import com.leaquan.petinder.ui.check_in.forgot_password.ForgotPasswordFragment
import com.leaquan.petinder.ui.check_in.register.RegisterFragment
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

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        var currentUser = auth.getCurrentUser()
        //updateUI(currentUser);
    }

    override fun setUp() {
        with(binding) {

            val ToastCus = com.leaquan.petinder.util.type.Toast.Type.WARNING of com.leaquan.petinder.util.type.Toast.Duration.SHORT

            WTF(ToastCus.toString())

            tvForgotPassword.gradientText()

            tvForgotPassword.onClick {
                activity?.pushFragment(
                    ForgotPasswordFragment.instance(TAG!!)
                )
            }

            ivShowPassword.onClick {
                edtPassword.transformation(it)
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
            }

            layoutSocial.btnGoogle.onClick {

                //authGoogle()
            }

            layoutSocial.btnPhone.onClick {

            }
        }
    }

//    private fun authGoogle() {
//        val googleCredential = oneTapClient.getSignInCredentialFromIntent(data)
//        val idToken = googleCredential.googleIdToken
//        when {
//            idToken != null -> {
//                // Got an ID token from Google. Use it to authenticate
//                // with Firebase.
//                val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
//                auth.signInWithCredential(firebaseCredential)
//                    .addOnCompleteListener(this) { task ->
//                        if (task.isSuccessful) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithCredential:success")
//                            val user = auth.currentUser
//                            updateUI(user)
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithCredential:failure", task.exception)
//                            updateUI(null)
//                        }
//                    }
//            }
//            else -> {
//                // Shouldn't happen.
//                Log.d(TAG, "No ID token!")
//            }
//        }
//    }

    override fun setUpObserver() {
    }
}