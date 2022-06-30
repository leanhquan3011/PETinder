package com.leaquan.petinder.di

import org.kodein.di.Kodein

const val FIREBASE_MODULE = "firebase_module"

val firebaseModule = Kodein.Module(FIREBASE_MODULE, false) {

}