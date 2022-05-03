package com.claudiogalvaodev.nttdatarevisao.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.claudiogalvaodev.nttdatarevisao.model.Dog
import com.claudiogalvaodev.nttdatarevisao.model.DogApiResult
import com.claudiogalvaodev.nttdatarevisao.repository.DogRepository
import com.claudiogalvaodev.nttdatarevisao.repository.IDogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DogViewModel(
    private val dogRepository: IDogRepository
) : ViewModel() {

    private val _dogs = MutableLiveData<DogApiResult<List<Dog>>>()
    val dogs: LiveData<DogApiResult<List<Dog>>> = _dogs

    fun getDogsFromRetrofit() {
        viewModelScope.launch {
            _dogs.value = DogApiResult.Loading()
            try {
                val dogsFromApi = withContext(Dispatchers.IO) {
                    dogRepository.getDogs()
                }
                _dogs.value = DogApiResult.Success(dogsFromApi)
            } catch (e: Exception) {
                val dogResult = DogApiResult.Error<List<Dog>>(e)
                _dogs.value = dogResult
            }
        }
    }
}

class DogViewModelFactory(private val repository: IDogRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DogViewModel(repository) as T
    }
}
