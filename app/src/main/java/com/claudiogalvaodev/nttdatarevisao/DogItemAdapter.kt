package com.claudiogalvaodev.nttdatarevisao

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.claudiogalvaodev.nttdatarevisao.databinding.DogListItemBinding
import com.claudiogalvaodev.nttdatarevisao.model.Dog

class DogItemAdapter(
    val onClickListener: (dogId: String) -> Unit
): ListAdapter<Dog, DogItemAdapter.DogItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogItemViewHolder {
        return DogItemViewHolder.create(parent, onClickListener)
    }

    override fun onBindViewHolder(holder: DogItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DogItemViewHolder(
        private val binding: DogListItemBinding,
        private val onClickListener: (dogId: String) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(dog: Dog) {
            binding.dogName.text = dog.name
            binding.dogBredForAndBreedGroup.text = binding.root.context.getString(
                R.string.dog_bred_for_and_breed_group,
                dog.bred_for, dog.breed_group
            )

            Glide
                .with(binding.root.context)
                .load(dog.image.url)
                .centerCrop()
                .into(binding.dogImage)

            binding.root.setOnClickListener {
                onClickListener.invoke(dog.id)
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onClickListener: (dogId: String) -> Unit
            ): DogItemViewHolder {
                val binding = DogListItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return DogItemViewHolder(binding, onClickListener)
            }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Dog>() {
            override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
                return oldItem == newItem
            }
        }
    }

}