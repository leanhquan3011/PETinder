package com.leaquan.petinder.util.firebase
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.leaquan.petinder.data.BaseDataSource


class FireBaseProvider : BaseDataSource() {

    //login google -> map callback to result

    //setup & register callback facebook
    //login facebook -> map call back to result(data)
    private val loginManager: LoginManager = LoginManager.getInstance()

    suspend fun registerCallback(callback : CallbackManager) = getResult {
        loginManager.registerCallback(callback, object : FacebookCallback<LoginResult> {
            override fun onCancel() {

            }

            override fun onError(error: FacebookException) {
            }

            override fun onSuccess(result: LoginResult) {

            }
        })
    }


    //setup & resister callback phone
    //send otp -> result(data)
    //verify(data) -> Unit
    //login phone -> map callback to result
}