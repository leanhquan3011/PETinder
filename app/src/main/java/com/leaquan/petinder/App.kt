package com.leaquan.petinder

import android.app.Application
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

class App : Application() {

    companion object {

        //this field are immediately made visible to other threads.
        @Volatile
        private var instance : App? = null

        //static methods for functions
        @JvmStatic
        fun getInstance () : App = instance ?: synchronized(this) {
            instance ?: App().also {
                instance = it
            }
        }

        fun getString(@StringRes strId: Int): String {
            return getResource().getString(strId)
        }

        fun getDrawableResource(@DrawableRes drawableRes: Int): Drawable? {
            return ContextCompat.getDrawable(getInstance(), drawableRes)
        }

        fun getResource(): Resources {
            return getInstance().resources
        }
    }

}