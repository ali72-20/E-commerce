package com.example.domain.core

sealed class ApiResult<T> {
    class Success<T>(val data: T) : ApiResult<T>()
    class Failure<T>(val exception: Exception) : ApiResult<T>()
}

