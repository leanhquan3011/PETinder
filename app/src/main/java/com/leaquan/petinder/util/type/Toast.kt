package com.leaquan.petinder.util.type

class Toast {

    data class ToastCus(val type: Type, val duration: Duration)

    enum class Duration (val duration : Int) {
        LONG(7000),
        SHORT(4000)
    }
    enum class Type (val type : String) {
        SUCCESS("SUCCESS"),
        ERROR("ERROR"),
        WARNING("WARNING");

        infix fun of (duration: Duration) = ToastCus(this, duration)
    }
}