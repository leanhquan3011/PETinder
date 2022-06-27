package com.leaquan.petinder.util.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DKodein
import org.kodein.di.generic.instanceOrNull

/**
 * this ViewModelFactory authority for KodeinDI.direct instance create viewModel
 * @param -Kodein-DI
 * @return instance of this
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val injector : DKodein) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return (injector.instanceOrNull<ViewModel>(tag = modelClass.simpleName) as T?
            ?: modelClass.newInstance())
    }
}



/*this factory setup
TODO
* class LessonPracticeViewModelFactory : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LessonPracticeViewModel::class.java)) {
            return LessonPracticeViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
*/

