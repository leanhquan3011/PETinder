package com.leaquan.petinder.di
import com.google.firebase.auth.FirebaseAuth
import org.kodein.di.Kodein
import org.kodein.di.generic.singleton

const val FIREBASE_MODULE = "firebase_module"

val firebaseModule = Kodein.Module(FIREBASE_MODULE, false) {
    singleton { FirebaseAuth.getInstance() }
}