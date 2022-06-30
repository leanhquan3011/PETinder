package com.leaquan.petinder.ui.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R
import com.leaquan.petinder.util.type.EnumValue


class EdittextPET : androidx.appcompat.widget.AppCompatEditText {

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(ctx : Context, attrs: AttributeSet?) {
        val typeArray : TypedArray = ctx.obtainStyledAttributes(attrs, R.styleable.EdittextPET)
        val textStyle = typeArray.getInt(R.styleable.EdittextPET_fontType, EnumValue.NORMAL.type)
        setFontType(EnumValue.valueOf(textStyle))
        typeArray.recycle()
    }

    private fun setFontType(style: EnumValue) {
        when(style){
            EnumValue.TITLE ->{
                typeface = Typeface.create(PETinderApplication.getResources().getFont(R.font.baloobhaina_regular), Typeface.BOLD)
            }
            EnumValue.NORMAL ->{
                typeface = Typeface.create(PETinderApplication.getResources().getFont(R.font.nuby_semibold), Typeface.NORMAL)
            }
            EnumValue.BOLD ->{
                typeface = Typeface.create(PETinderApplication.getResources().getFont(R.font.nuby_bold), Typeface.BOLD_ITALIC)
            }
            EnumValue.EXTRA_BOLD ->{
                typeface = Typeface.create(PETinderApplication.getResources().getFont(R.font.nuby_extrabold), Typeface.BOLD_ITALIC)
            }
            EnumValue.ITALIC ->{
                typeface = Typeface.create(PETinderApplication.getResources().getFont(R.font.nuby_light), Typeface.ITALIC)
            }
        }
    }
}