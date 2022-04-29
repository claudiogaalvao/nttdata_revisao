package com.claudiogalvaodev.nttdatarevisao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.claudiogalvaodev.nttdatarevisao.client.IDogClient
import com.claudiogalvaodev.nttdatarevisao.databinding.ActivityDogListBinding
import com.claudiogalvaodev.nttdatarevisao.model.Dog
import com.claudiogalvaodev.nttdatarevisao.model.Image
import com.claudiogalvaodev.nttdatarevisao.model.Measure
import com.claudiogalvaodev.nttdatarevisao.model.mockDogs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogListActivity : AppCompatActivity() {

    // API https://thedogapi.com/
    // endpoint https://docs.thedogapi.com/api-reference/breeds/breeds-list

    // Reference initialize activity with fragment: https://developer.android.com/guide/fragments/create

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
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

    private val binding by lazy {
        ActivityDogListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.dogListRecyclerview.adapter = dogListAdapter

        getDogs()
        //setupAdapter(mockDogs())
    }

    fun getDogs() {
        lifecycleScope.launch {
            var listDogs: List<Dog>
            withContext(Dispatchers.IO){
                //call API
                val result = dogClient.getPublicDogs()

                //transform json to match dog
                listDogs = result.map { dog ->
                    Dog(
                        id = dog.id,
                        name = dog.breeds.firstOrNull()?.name ?: "Default Name",
                        bred_for =  "",
                        breed_group = "",
                        life_span = dog.breeds.firstOrNull()?.life_span ?: "",
                        origin = dog.breeds.firstOrNull()?.origin ?: "",
                        country_code = dog.breeds.firstOrNull()?.country_code,
                        reference_image_id = dog.breeds.firstOrNull()?.reference_image_id ?: "",
                        temperament = dog.breeds.firstOrNull()?.temperament ?: "",
                        image = Image(
                            id = dog.id,
                            url = dog.url,
                            height = dog.height,
                            width = dog.width
                        ),
                        height = dog.breeds.firstOrNull()?.let{ breed ->
                            Measure(breed.weight.imperial,breed.weight.metric)
                        } ?: Measure("",""),
                        weight = dog.breeds.firstOrNull()?.let{ breed ->
                            Measure(breed.weight.imperial,breed.weight.metric)
                        } ?: Measure("","")
                    )
                }
            }

            setupAdapter(listDogs)

        }
    }

    fun setupAdapter(list: List<Dog>) {
        dogListAdapter.submitList(list)
    }



    private fun goToDogDetails(dogId: String) {
        startActivity(DogDetailsActivity.newIntent(context = this, dogId = dogId))
    }
}