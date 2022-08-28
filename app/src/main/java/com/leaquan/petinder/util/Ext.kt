package com.leaquan.petinder.util

import android.content.Context
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.leaquan.petinder.ui.view.ToastPET
import com.leaquan.petinder.util.type.Toast


// TODO: Make this clear
inline fun <T, R : LiveData<T>>  Fragment.onObserverDataChanged (liveData: R,crossinline onChanged : (T) -> Unit) {
    liveData.observe(this) {
        it?.let {
           onChanged(it)
        }
    }
}

// TODO: Make this clear
inline fun <T, R : LiveData<T>> AppCompatActivity.onObserverDataChanged (liveData: R, crossinline onChanged : (T) -> Unit) {
    liveData.observe(this) { observer ->
        observer?.let { data ->
            onChanged(data)
        }
    }
}

fun WTF(msg: String?, tag: String = "WTF"): Int{
    return Log.e(tag, "$msg")
}

//TODO make this clear
inline fun <reified T: View> T.onClick(crossinline onClick: (view: T) -> Unit){
    setOnClickListener {
        onClick.invoke(it as T)
    }
}

fun<T : Context> T.showShortToast(message: String, type: Toast.Type) {
    ToastPET(this).makeText(
        context = this,
        message = message,
        type = type of Toast.Duration.SHORT
    )?.show()
}

fun <T: Context> T.showLongToast (message: String, type: Toast.Type) {
    ToastPET(this).makeText(
        context = this,
        message = message,
        type = type of Toast.Duration.LONG
    )?.show()
}
