package com.claudiogalvaodev.nttdatarevisao.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.claudiogalvaodev.nttdatarevisao.ui.adapter.DogItemAdapter
import com.claudiogalvaodev.nttdatarevisao.client.IDogClient
import com.claudiogalvaodev.nttdatarevisao.databinding.ActivityDogListBinding
import com.claudiogalvaodev.nttdatarevisao.model.Dog
import com.claudiogalvaodev.nttdatarevisao.model.DogApiResult
import com.claudiogalvaodev.nttdatarevisao.repository.DogRepository
import com.claudiogalvaodev.nttdatarevisao.ui.viewmodel.DogViewModel
import com.claudiogalvaodev.nttdatarevisao.ui.viewmodel.DogViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogListActivity : AppCompatActivity() {

    // API https://thedogapi.com/
    // endpoint https://docs.thedogapi.com/api-reference/breeds/breeds-list

    // Reference initialize activity with fragment: https://developer.android.com/guide/fragments/create

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val dogClient:IDogClient by lazy {
        retrofit.create(IDogClient::class.java)
    }

    private val dogListAdapter by lazy {
        DogItemAdapter(onClickListener = { dogId ->
            goToDogDetails(dogId)
        })
    }

    private val dogRepository = DogRepository(dogClient)
    private val dogFactory = DogViewModelFactory(dogRepository)
    private val dogViewModel by viewModels<DogViewModel>{ dogFactory }

    private val binding by lazy {
        ActivityDogListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.dogListRecyclerview.adapter = dogListAdapter
        getDogsAndObserve()
    }

    private fun getDogsAndObserve() {
        dogViewModel.getDogsFromRetrofit()
        dogViewModel.dogs.observe(this) { dogApiResult ->
            when(dogApiResult) {
                is DogApiResult.Loading -> {
                    Log.d("INFO", "Loading")
                }
                is DogApiResult.Success -> {
                    Log.d("INFO", "Success")
                    setupAdapter(dogApiResult.data)
                }
                is DogApiResult.Error -> {
                    Log.d("INFO", "Error: ${dogApiResult.throwable.cause}")
                }
            }
        }
    }

//    fun getDogs() {
//        lifecycleScope.launch {
//            var listDogs: List<Dog>
//            withContext(Dispatchers.IO){
//                //call API
//                val result = dogClient.getBreeds()
//
//                listDogs = result
//            }
//
//            setupAdapter(listDogs)
//
//        }
//    }

    fun setupAdapter(list: List<Dog>) {
        dogListAdapter.submitList(list)
    }



    private fun goToDogDetails(dogId: Int) {
        startActivity(DogDetailsActivity.newIntent(context = this, dogId = dogId))
    }
}