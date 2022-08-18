package com.leaquan.petinder.ui.check_in.country_dialog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.leaquan.petinder.R
import com.leaquan.petinder.databinding.ItemAlphabetBinding
import com.leaquan.petinder.ui.check_in.country_dialog.model.Alphabet
import com.leaquan.petinder.util.extension.onClick

class AlphabetAdapter(
    private val alphabets : List<Alphabet> = listOf(),
    private val onAlphabetSelected : (Alphabet) -> Unit
) : RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        return AlphabetViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_alphabet,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        val alphabet = alphabets[position]
        holder.binding.alphabet = alphabet
        holder.binding.root.onClick {
            onAlphabetSelected.invoke(alphabet)
        }
    }

    override fun getItemCount(): Int = alphabets.size

    class AlphabetViewHolder(val binding : ItemAlphabetBinding) : RecyclerView.ViewHolder(binding.root)

}