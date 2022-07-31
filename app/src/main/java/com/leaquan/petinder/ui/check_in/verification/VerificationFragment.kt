package com.leaquan.petinder.ui.check_in.verification

import android.content.Intent
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentVerificationBinding
import com.leaquan.petinder.ui.check_in.login.LoginFragment
import com.leaquan.petinder.ui.home.HomeActivity
import com.leaquan.petinder.ui.splash.SplashActivity
import com.leaquan.petinder.util.BundleKey.Companion.PHONE_NUMBER
import com.leaquan.petinder.util.extension.WTF
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.type.Toast
import com.leaquan.petinder.util.viewmodel.kodeinViewModel
import java.util.concurrent.TimeUnit

class VerificationFragment: BaseFragmentMVVM<FragmentVerificationBinding, VerificationViewModel>() {

    companion object {
        fun instance(phone : String) : VerificationFragment {
            return VerificationFragment().apply {
                arguments = bundleOf().apply {
                    putString(PHONE_NUMBER, phone)
                }
            }
        }
    }

    override fun inflateLayout(): Int = R.layout.fragment_verification

    override val viewModel: VerificationViewModel by kodeinViewModel()

    private val phone by lazy { arguments?.getString(PHONE_NUMBER) }

    private lateinit var auth : FirebaseAuth

    override fun setUp() {
        auth = FirebaseAuth.getInstance()
        auth.setLanguageCode("vi")
        with(binding) {
            btnSend.onClick {
                val otp = otpView.getStringFromFields().trim()

                if(otp.isNotEmpty()){
                    val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(phone.toString(), otp)
                    signInWithPhoneAuthCredential(credential)
                }else{
                    showShortToast(
                        "Enter OTP",
                        Toast.Type.ERROR
                    )
                }
            }
        }
    }
    override fun setUpObserver() {

    }

    // verifies if the code matches sent by firebase
    // if success start the new activity in our case it is main Activity
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential).addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(activity , HomeActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                } else {
                    // Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        showShortToast(
                            "Invalid OTP",
                            Toast.Type.ERROR
                        )
                        WTF(task.exception.toString())
                    }
                }
            }
    }

}

