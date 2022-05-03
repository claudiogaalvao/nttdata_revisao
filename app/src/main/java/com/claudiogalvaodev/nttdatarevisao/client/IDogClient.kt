package com.claudiogalvaodev.nttdatarevisao.client

import com.claudiogalvaodev.nttdatarevisao.model.Dog
import retrofit2.http.*

interface IDogClient {

    @GET("v1/breeds")
    @Headers("x-api-key: 4f256f5a-cdb1-4880-96c8-3ae1f9f1f86c")
    suspend fun getBreeds(): List<Dog>

}