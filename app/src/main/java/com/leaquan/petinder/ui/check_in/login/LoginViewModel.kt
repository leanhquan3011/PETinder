package com.leaquan.petinder.ui.check_in.login

import androidx.lifecycle.MutableLiveData
import com.facebook.CallbackManager
import com.leaquan.petinder.base.viewmodel.BaseViewModel
import com.leaquan.petinder.data.Result
import com.leaquan.petinder.data.repository.OauthRepository
import kotlinx.coroutines.coroutineScope

class LoginViewModel(
    private val oauthRepository: OauthRepository
) : BaseViewModel() {

    private val _result = MutableLiveData<Result<String>>()
    val result get() = _result

    fun requestFacebookLogin(callbackManager: CallbackManager) {
        _result.value = Result.Loading()
    }
}