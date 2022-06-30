package com.leaquan.petinder.ui.welcome.fragments

import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R

class Item1 : BaseItemWelcome() {

    override fun inflateTitle(): String = PETinderApplication.getString(R.string.description_title1)

    override fun inflateDescription(): String = PETinderApplication.getString(R.string.description_content1)

    override fun inflateSrcImg(): Int = R.drawable.img_welcom1
}