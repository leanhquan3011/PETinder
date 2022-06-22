package com.leaquan.petinder.di

import org.kodein.di.Kodein.Module

// TODO: Make this clear
const val APP_MODULE = "app_module"

val appModule = Module(APP_MODULE, false) {
    import(viewModelModule)
}