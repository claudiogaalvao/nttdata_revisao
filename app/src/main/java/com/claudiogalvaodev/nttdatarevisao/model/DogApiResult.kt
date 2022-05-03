package com.claudiogalvaodev.nttdatarevisao.model

sealed class DogApiResult <T> {
    class Loading<T>: DogApiResult<T>()
    class Success<T>(val data: T): DogApiResult<T>()
    class Error<T>(val throwable: Throwable): DogApiResult<T>()
}