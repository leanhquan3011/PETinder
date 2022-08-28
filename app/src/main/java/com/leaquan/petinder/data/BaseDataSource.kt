package com.leaquan.petinder.data


abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> T) : Result<T> {
        return try {
            val result = call()
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e.message ?: e.toString())
        }
    }
}