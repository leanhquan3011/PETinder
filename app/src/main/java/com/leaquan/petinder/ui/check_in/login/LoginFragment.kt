package com.leaquan.petinder.ui.check_in.login

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentLoginBinding
import com.leaquan.petinder.ui.check_in.forgot_password.ForgotPasswordFragment
import com.leaquan.petinder.ui.check_in.register.RegisterFragment
import com.leaquan.petinder.ui.home.HomeActivity
import com.leaquan.petinder.util.Social
import com.leaquan.petinder.util.extension.WTF
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.pushFragment
import com.leaquan.petinder.util.text.gradientText
import com.leaquan.petinder.util.view_extension.transformation
import com.leaquan.petinder.util.viewmodel.kodeinViewModel
import java.util.*


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

    private lateinit var callbackManager : CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        callbackManager = CallbackManager.Factory.create()
    }

    override fun onStart() {
        super.onStart()
        var currentUser = auth.getCurrentUser()
        //updateUI(currentUser);
    }

    override fun setUp() {
        with(binding) {

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
                val intent = Intent(activity , HomeActivity::class.java)
                startActivity(intent)
            }

            btnRegister.onClick {
                activity?.pushFragment(
                    RegisterFragment.instance(TAG!!)
                )
            }

            layoutSocial.btnFacebook.onClick {
                layoutSocial.loginFacebook.performClick()
                loginWithFaceBook()
                WTF("click roi mi")
            }

            layoutSocial.btnGoogle.onClick {
                //authGoogle()
            }

            layoutSocial.btnPhone.onClick {
                activity?.pushFragment(
                    ForgotPasswordFragment()
                )
            }
        }
    }

    private fun loginWithFaceBook() {
        with(binding.layoutSocial) {
            loginFacebook.setPermissions(Social.facebook_permissions)


            // Callback registration
            // If you are using in a fragment, call loginButton.setFragment(this);

            // Callback registration
            loginFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

                override fun onCancel() {
                    WTF("facebook: cancel")
                }

                override fun onError(error: FacebookException) {
                    WTF("facebook:onError  $error")
                }

                override fun onSuccess(result: LoginResult) {
                    WTF("facebook:onSuccess:$result")
                    handleFacebookAccessToken(result.accessToken)
                    resultActivity.contract.apply {

                    }
                }
            })

        }
    }

    private val resultActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
        }
    }

    private fun handleFacebookAccessToken(accessToken: AccessToken) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    override fun setUpObserver() {
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
    }


}