package com.leaquan.petinder.ui.welcome.fragments

import com.leaquan.petinder.App
import com.leaquan.petinder.R

class Item1 : BaseItemWelcome() {

    override fun inflateTitle(): String = App.getString(R.string.description_title1)

    override fun inflateDescription(): String = App.getString(R.string.description_content1)

    override fun inflateSrcImg(): Int = R.drawable.img_welcom1
}