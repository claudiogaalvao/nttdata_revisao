package com.claudiogalvaodev.nttdatarevisao.repository

import com.claudiogalvaodev.nttdatarevisao.model.Dog

interface IDogRepository {

    suspend fun getDogs(): List<Dog>

}
