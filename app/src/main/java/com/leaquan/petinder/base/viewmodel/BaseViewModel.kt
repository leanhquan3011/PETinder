package com.leaquan.petinder.base.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    //TODO("Not yet research")
    
    private var job: Job = Job()
    var ioContext: CoroutineContext = Dispatchers.IO + job

    open fun onCreate() {}

    open fun onDestroy() {
        job.cancel()
    }
    
}