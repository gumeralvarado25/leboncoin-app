package com.leboncoin.leboncoin_domain.utils

sealed class AlbumResult<out T> {
    data class Success<out T>(val data: T) : AlbumResult<T>()
    data class Failure<T>(val error: AlbumError) : AlbumResult<T>()
}