package com.claudiogalvaodev.nttdatarevisao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.claudiogalvaodev.nttdatarevisao.databinding.ActivityDogListBinding
import com.claudiogalvaodev.nttdatarevisao.model.mockDogs

class DogListActivity : AppCompatActivity() {

    // API https://thedogapi.com/
    // endpoint https://docs.thedogapi.com/api-reference/breeds/breeds-list

    // Reference initialize activity with fragment: https://developer.android.com/guide/fragments/create

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
        dogListAdapter.submitList(mockDogs())
    }

    private fun goToDogDetails(dogId: Int) {
        startActivity(DogDetailsActivity.newIntent(context = this, dogId = dogId))
    }
}