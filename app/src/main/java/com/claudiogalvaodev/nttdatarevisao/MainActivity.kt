package com.claudiogalvaodev.nttdatarevisao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.claudiogalvaodev.nttdatarevisao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // API https://thedogapi.com/
    // endpoint https://docs.thedogapi.com/api-reference/breeds/breeds-list

    // Reference initialize activity with fragment: https://developer.android.com/guide/fragments/create

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}