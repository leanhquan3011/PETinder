package com.leaquan.petinder.ui.check_in.country_dialog.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.leaquan.petinder.R
import com.leaquan.petinder.databinding.ItemNationalBinding
import com.leaquan.petinder.ui.check_in.country_dialog.model.Countries
import com.leaquan.petinder.ui.check_in.country_dialog.model.Country
import com.leaquan.petinder.util.onClick

class NationalAdapter(
    private val context : Context?,
    private val nationalSelected : (Country) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val countries = Countries().countries

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NationalViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_national,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val nationHolder = holder as NationalViewHolder
        val item = countries[position]

        nationHolder.binding.country = item

        context?.let {
            nationHolder.binding.ivNationalFlag.setImageResource(item.getResId(it))
        }

        nationHolder.binding.root.onClick {
            nationalSelected.invoke(item)
        }
    }

    override fun getItemCount(): Int = countries.size

    inner class NationalViewHolder(
        val binding : ItemNationalBinding
    ) : RecyclerView.ViewHolder(binding.root)
}