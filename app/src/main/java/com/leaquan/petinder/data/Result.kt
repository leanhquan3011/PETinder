package com.leaquan.petinder.data

sealed class Result<T> (
    data : T?,
    message : String? = null
){
    class Loading<T> : Result<T>(null)
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(exception: String?) : Result<T>(message = exception, data =  null)
}