package com.leaquan.petinder.data.repository

import com.facebook.CallbackManager
import com.leaquan.petinder.data.BaseResponse
import com.leaquan.petinder.data.network.response.OauthResponse
import com.leaquan.petinder.util.firebase.FireBaseProvider

class OauthRepository (
    private val fireBaseProvider: FireBaseProvider
) {

    //request login facebook -> Result
    suspend fun requestLoginFaceBook(callbackManager: CallbackManager) {
         fireBaseProvider.registerCallback(callbackManager)
    }


    //request login google -> Result
    //request verify phone -> result
    //request otp -> otp
    //request login with otp ->

}