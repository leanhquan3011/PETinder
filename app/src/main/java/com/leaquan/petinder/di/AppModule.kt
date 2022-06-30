package com.leaquan.petinder.di

import org.kodein.di.Kodein.Module

const val APP_MODULE = "app_module"

/**  import all dependency modules here  */
val appModule = Module(APP_MODULE, false) {
    import(viewModelModule)
    import(firebaseModule)
}

/** singleTon()
 * Creates a singleton: will create an instance on first request and will subsequently always return the same instance.
 *
 * T generics will be kept.
 *
 * @param T The created type.
 * @param creator The function that will be called the first time an instance is requested. Guaranteed to be called only once. Should create a new instance.
 * @return A singleton ready to be bound.
 */

/** instance()
 * Creates an instance provider: will always return the given instance.
 *
 * T generics will be kept.
 *
 * @param T The type of the instance.
 * @param instance The object that will always be returned.
 * @return An instance provider ready to be bound.
 */


/**
 *  Factory: The factory bind function allows you to pass an argument of a certain type
 *  and return an instance of another type. A factory can take up to five arguments.
 *
 *
 *  Provider: The provider function takes no argument and returns the bound type.
 *  It will be called every time you need an instance of the bound type.
 */


/** @ANNOTATION
 * Inject: This annotation can be used in two ways:
1. Telling dagger to use this constructor to make an object of this type.
This injection is recursive which means that if the constructor has parameters dagger
will automatically try to inject them too.

2. Used by a component to tell dagger that it wants this dependency.
 */
