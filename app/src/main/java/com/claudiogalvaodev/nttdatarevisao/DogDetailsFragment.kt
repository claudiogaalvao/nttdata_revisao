package com.claudiogalvaodev.nttdatarevisao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.claudiogalvaodev.nttdatarevisao.databinding.DogDetailsFragmentBinding
import com.claudiogalvaodev.nttdatarevisao.model.mockDogs

private const val ARG_DOG_ID = "dogId"

class DogDetailsFragment: Fragment() {

    private val binding by lazy {
        DogDetailsFragmentBinding.inflate(layoutInflater)
    }

    private val dogId by lazy {
        arguments?.getInt(ARG_DOG_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dogSelected = mockDogs().find { dog -> dog.id == dogId }

        dogSelected?.let {
            binding.dogName.text = it.name
            binding.dogBredForAndBreedGroup.text = binding.root.context
                .getString(R.string.dog_bred_for_and_breed_group, it.bred_for, it.breed_group)
            binding.dogLifeSpan.text = it.life_span
            binding.dogTemperament.text = it.temperament
        }
    }

    companion object {
        fun newInstance(dogId: Int) = DogDetailsFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_DOG_ID, dogId)
            }
        }
    }

}