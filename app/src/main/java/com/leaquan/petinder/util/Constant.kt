package com.leaquan.petinder.util

class Constant {
    companion object {
        //animation
        const val DEFAULT_ANIMATION  = 0
        const val SHORT_ANIMATION : Long = 200
        const val MEDIUM_ANIMATION : Long = 400
        const val LONG_ANIMATION : Long = 600
        const val SPLASH_TIMER : Long = 1500

        //stateViewpager
        const val IN_PREVIEW = 0
        const val END_PREVIEW = 1
        const val ACTION = 2

    }
}

class Social {
    companion object {
        val facebook_permissions = mutableListOf("email", "public_profile")
    }
}

class BundleKey {
    companion object {
        //check in
        const val PHONE_NUMBER = "PHONE_NUMBER"
        const val BOTTOM_SHEET_HEIGHT_VALUE = "BOTTOM_SHEET_HEIGHT_VALUE"
        const val COUNTRY_SELECTED = "COUNTRY_SELECTED"
    }
}
