package com.claudiogalvaodev.nttdatarevisao

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.claudiogalvaodev.nttdatarevisao.databinding.DogListFragmentBinding
import com.claudiogalvaodev.nttdatarevisao.model.mockDogs

class DogListFragment: Fragment() {

    private val binding by lazy {
        DogListFragmentBinding.inflate(layoutInflater)
    }

    private val dogListAdapter by lazy {
        DogItemAdapter(onClickListener = { dogId ->
            replaceCurrentFragmentForDogDetails(dogId)
        })
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

        binding.dogListRecyclerview.adapter = dogListAdapter
        dogListAdapter.submitList(mockDogs())
    }

    private fun replaceCurrentFragmentForDogDetails(dogId: Int) {
        val newFragment = DogDetailsFragment.newInstance(dogId)
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.nav_host_fragment, newFragment)
        transaction?.addToBackStack(newFragment.tag)
        transaction?.commit()
    }

}