package com.leaquan.petinder.util.view_model

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


//todo research Ejection
inline fun <reified T : ViewModel> Kodein.Builder.bindViewModel(overrides: Boolean? = null): Kodein.Builder.TypeBinder<T> {
    return bind<T>(T::class.java.simpleName, overrides)
}

//when (T) : Any = AppCompatActivity
inline fun <reified VM : ViewModel, T> T.kodeinViewModel(): Lazy<VM> where T : KodeinAware, T : AppCompatActivity {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}

//when (T) : Any = Fragment
inline fun <reified VM : ViewModel, T> T.kodeinViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}

//require activity lifecycle of (Fragment) when use VM in SingleActivity
inline fun <reified VM : ViewModel, T> T.kodeinViewModelFromActivity(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProvider(this.requireActivity(), direct.instance()).get(VM::class.java) }
}

/*
*  - this function kodeinViewModel has params <VM : ViewModel AND (T) : Any> return Lazy<ViewModel>
*    when (T) is implement KodeinAware and Any
*
*    ViewModelProvider: Responsibility of this class is identifying the factory and caching view_model reference to ViewModelStore
*                       it will given a ViewModel independent each activity
*
*                       Params { (T), ViewModelProvider,get(ViewModel Ejection) }
 */