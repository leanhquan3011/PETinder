package com.leaquan.petinder.ui.welcome.fragments

import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R

class Item2 : BaseItemWelcome() {

    override fun inflateTitle(): String = PETinderApplication.getString(R.string.description_title2)

    override fun inflateDescription(): String = PETinderApplication.getString(R.string.description_content2)

    override fun inflateSrcImg(): Int = R.drawable.img_welcom2
}