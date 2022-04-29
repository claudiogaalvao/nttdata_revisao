package com.claudiogalvaodev.nttdatarevisao

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.claudiogalvaodev.nttdatarevisao.databinding.ActivityDogDetailsBinding
import com.claudiogalvaodev.nttdatarevisao.model.Dog
import com.claudiogalvaodev.nttdatarevisao.model.mockDogs

private const val ARG_DOG_ID = "dogId"

class DogDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDogDetailsBinding.inflate(layoutInflater)
    }

    private val dogId by lazy {
        intent.getStringExtra(ARG_DOG_ID) ?: "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dogSelected = mockDogs().find { dog -> dog.id == dogId.toString() }

        setData(dogSelected)
    }

    private fun setData(dogSelected: Dog?) {
        dogSelected?.let {
            binding.dogName.text = it.name
            binding.dogBredForAndBreedGroup.text = binding.root.context
                .getString(R.string.dog_bred_for_and_breed_group, it.bred_for, it.breed_group)
            binding.dogLifeSpan.text = it.life_span
            binding.dogTemperament.text = it.temperament
        }
    }

    companion object {
        fun newIntent(context: Context, dogId: String) = Intent(
            context, DogDetailsActivity::class.java
        ).apply {
            putExtra(ARG_DOG_ID, dogId)
        }
    }
}