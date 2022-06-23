package com.leaquan.petinder.util.view_model

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

/**
 *  - this function kodeinViewModel has params <VM : ViewModel AND <T> : Any> return Lazy<ViewModel>
 *       @param            viewModelClass a {@code Class} whose instance is requested
 *       @param <T>        The type parameter for the ViewModel.  ( when <T> is implement KodeinAware and Any )
 *       @return a newly created ViewModel by lazy
 *
 *    ViewModelProvider: Responsibility of this class is identifying the factory and caching view_model reference to ViewModelStore
 *                       it will given a ViewModel independent each activity
 *
 *                       Params { <T>, ViewModelProvider, ViewModel Ejection get(VM) }
 */

/**{when (T) : Any = AppCompatActivity}*/
inline fun <reified VM : ViewModel, T> T.kodeinViewModel(): Lazy<VM> where T : KodeinAware, T : AppCompatActivity {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}

/**{when (T) : Any = Fragment}*/
inline fun <reified VM : ViewModel, T> T.kodeinViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}

/**{require activity lifecycle of (Fragment) when use VM in SingleActivity}*/
inline fun <reified VM : ViewModel, T> T.kodeinViewModelFromActivity(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProvider(this.requireActivity(), direct.instance()).get(VM::class.java) }
}

/**
 * bind TypeBinder by default
 *      inline fun <reified T : Any> Kodein.Builder.bind(tag: Any? = null, overrides: Boolean? = null) : Kodein.Builder.TypeBinder<T> {
 *           return Bind<T>(generic(), tag, overrides) //tag none, override false
 *      }
 * {@sample bindViewModel}
 *      this function intent to ViewModel and mapping TAG to each viewModel when bind
 *      @param viewModel input
 *      @return bind<T>(ViewModel.name, can override.default = false)
 */
inline fun <reified T : ViewModel> Kodein.Builder.bindViewModel(overrides: Boolean? = null): Kodein.Builder.TypeBinder<T> {
    return bind<T>(T::class.java.simpleName, overrides)
}
