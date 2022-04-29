package com.claudiogalvaodev.nttdatarevisao.client

import com.claudiogalvaodev.nttdatarevisao.model.Dog
import retrofit2.http.*

interface IDogClient {

    @GET("v1/breeds")
    @Headers("x-api-key: 4f256f5a-cdb1-4880-96c8-3ae1f9f1f86c")
    suspend fun getBreeds(): List<Dog>

    /*
    @GET("v1/images/search")
    @Headers("x-api-key: 4f256f5a-cdb1-4880-96c8-3ae1f9f1f86c")
    suspend fun getPublicDogs(
        @Query("limit") limit: String = "10",
        @Query("page") page: String = "0"
    ): List<DogImageModel>

    @GET("v1/images")
    @Headers("x-api-key: 4f256f5a-cdb1-4880-96c8-3ae1f9f1f86c")
    suspend fun getMyDogs(): List<DogImageModel> */



}