package com.leaquan.petinder.data.network.response

import com.facebook.AccessToken
import com.facebook.AuthenticationToken
import com.leaquan.petinder.data.BaseResponse
import java.io.Serializable

data class OauthResponse(
    val accessToken: AccessToken,
    val authenticationToken: AuthenticationToken? = null,
    val recentlyGrantedPermissions: Set<String>,
    val recentlyDeniedPermissions: Set<String>
) : Serializable