package com.leaquan.petinder.ui.check_in.country_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.leaquan.petinder.R
import com.leaquan.petinder.base.dialog.FullHeightBottomFragment
import com.leaquan.petinder.databinding.FragmentCountryListDialogBinding
import com.leaquan.petinder.ui.check_in.country_dialog.model.Country
import com.leaquan.petinder.util.BundleKey.Companion.BOTTOM_SHEET_HEIGHT_VALUE
import com.leaquan.petinder.util.BundleKey.Companion.COUNTRY_SELECTED
import com.leaquan.petinder.util.getScreenHeight

class CountryListDialog : FullHeightBottomFragment() {

    lateinit var binding : FragmentCountryListDialogBinding

    companion object {
        val TAG = CountryListDialog::class.simpleName
        var DEFAULT_HEIGHT = getScreenHeight()

        fun instance(
            height : Int = DEFAULT_HEIGHT,
            countrySelected : Country = Country.DEFAULT_COUNTRY
        ) = CountryListDialog().apply {
                arguments = Bundle().apply {
                    putInt(BOTTOM_SHEET_HEIGHT_VALUE, height)
                    putSerializable(COUNTRY_SELECTED, countrySelected)
                }
            }

    }

    private val height by lazy { arguments?.getInt(BOTTOM_SHEET_HEIGHT_VALUE) }
    private val countrySelected by lazy { arguments?.getSerializable(COUNTRY_SELECTED) as Country? ?: Country.DEFAULT_COUNTRY}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_country_list_dialog,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        rvCountry()
        rvAlphabet()
    }

    private fun rvAlphabet() {
        TODO("Not yet implemented")
    }

    private fun rvCountry() {
        TODO("Not yet implemented")
    }

}