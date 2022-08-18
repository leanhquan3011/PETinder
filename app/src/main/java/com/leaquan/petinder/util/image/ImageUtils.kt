package com.leaquan.petinder.util.image
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

//@BindingAdapter("loadDrawableImage")
//fun loadDrawableImage(view: ImageView, resId: Int?) {
//    resId?.let {
//        view.setImageResource(it)
//    }
//}

//@BindingAdapter("imageUrl")
//fun loadImage(view: ImageView, url: String?) {
//    if (!url.isNullOrEmpty()) {
//        Glide.with(view)
//            .load(url)
//            .error(R.drawable.ic_okxe_small)
//            .into((view))
//    }
//}