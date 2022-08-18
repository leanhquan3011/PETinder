package com.leaquan.petinder.ui.check_in.forgot_password

import android.util.Log
import androidx.core.os.bundleOf
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragmentMVVM
import com.leaquan.petinder.databinding.FragmentForgotPasswordBinding
import com.leaquan.petinder.ui.check_in.country_dialog.CountryListDialog
import com.leaquan.petinder.ui.check_in.login.LoginFragment.Companion.FROM
import com.leaquan.petinder.ui.check_in.verification.VerificationFragment
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.pushFragment
import com.leaquan.petinder.util.type.Toast
import com.leaquan.petinder.util.viewmodel.kodeinViewModel
import java.util.concurrent.TimeUnit

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


    // create instance of firebase auth
    lateinit var auth: FirebaseAuth

    // we will use this to match the sent otp from firebase
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken


    override fun setUp() {
        auth = FirebaseAuth.getInstance()
        auth.setLanguageCode("vi")

        with(binding) {
            btnSend.onClick {
                login()
            }

            layoutCountry.onClick {
                showShortToast("cc", Toast.Type.WARNING)
                val dialog = CountryListDialog()
                dialog.show(childFragmentManager, CountryListDialog.TAG)
            }

        }
    }

    override fun setUpObserver() {
    }

    // Callback function for Phone Auth
    var callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        // This method is called when the verification is completed
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//            startActivity(Intent(activity, HomeActivity::class.java))
//            activity?.finish()
            Log.d("GFG" , "onVerificationCompleted Success")
        }

        // Called when verification is failed add log statement to see the exception
        override fun onVerificationFailed(e: FirebaseException) {
            Log.d("GFG" , "onVerificationFailed  $e")
        }

        // On code is sent by the firebase this method is called
        // in here we start a new activity where user can enter the OTP
        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            Log.d("GFG","onCodeSent: $verificationId")
            storedVerificationId = verificationId
            resendToken = token

            // Start a new activity using intent
            // also send the storedVerificationId using intent
            // we will use this id to send the otp back to firebase
            activity?.pushFragment(
                VerificationFragment.instance(
                    storedVerificationId
                )
            )
        }
    }

    private fun login() {
        // get the phone number from edit text and append the country cde with it
        if (binding.edtPhoneNumber.text.toString().isNotEmpty()){
            val number = "+84${binding.edtPhoneNumber.text}".trim()
            sendVerificationCode(number)
        }else{
           showShortToast(
               "Enter mobile number",
               Toast.Type.ERROR
           )
        }
    }

    // this method sends the verification code
    // and starts the callback of verification
    // which is implemented above in onCreate
    private fun sendVerificationCode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity()) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        Log.d("GFG" , "Auth started")
    }


}