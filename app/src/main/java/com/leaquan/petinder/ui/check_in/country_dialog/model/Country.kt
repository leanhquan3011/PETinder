package com.leaquan.petinder.ui.check_in.country_dialog.model

import android.content.Context
import java.io.Serializable
import java.util.*

data class Country (
        var mCode: String? = null,
        var mName: String? = null,
        var mDialCode : Int = 0,
        var isSelected : Boolean = false
) : Serializable {

        val code get() = mCode?.uppercase(Locale.ROOT)

        val displayName get() = mCode?.let { Locale("", it).getDisplayCountry(Locale.US) }

        fun getResId(context: Context): Int {
                val name = String.format("%s", mCode!!.lowercase(Locale.ROOT))
                val resources = context.resources
                return resources.getIdentifier(name, "drawable", context.packageName)
        }

        fun getCodeWithPrefix() = "+$mDialCode"

        companion object{
                val DEFAULT_COUNTRY = Country(
                        "vn",
                        "Vietnam (Việt Nam)",
                        84
                )
        }
}