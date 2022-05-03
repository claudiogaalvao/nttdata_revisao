package com.claudiogalvaodev.nttdatarevisao.repository

import com.claudiogalvaodev.nttdatarevisao.client.IDogClient
import com.claudiogalvaodev.nttdatarevisao.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository(
    private val dogClient: IDogClient
) : IDogRepository {

    override suspend fun getDogs(): List<Dog> {
        return dogClient.getBreeds()
    }
}
