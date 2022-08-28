package com.leaquan.petinder.data

import java.io.Serializable

data class BaseResponse<T>(
    val result: String?,
    val result_code: Int?,
    val success: Boolean?,
    val data: T?
): Serializable