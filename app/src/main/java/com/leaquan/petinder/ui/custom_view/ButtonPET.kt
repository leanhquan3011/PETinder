package com.leaquan.petinder.ui.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import com.leaquan.petinder.R
import com.leaquan.petinder.util.type.FontType

class ButtonPET : androidx.appcompat.widget.AppCompatButton {

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

    private fun init(context: Context, attrs: AttributeSet?) {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonPET)
        val textStyle = typedArray.getInt(R.styleable.ButtonPET_fontType, FontType.NORMAL.type)
        setFontType(FontType.valueOf(textStyle))
        typedArray.recycle()
    }

    private fun setFontType(style: FontType) {
        when(style){
            FontType.TITLE ->{
                typeface = Typeface.create(resources.getFont(R.font.baloobhaina_regular), Typeface.BOLD)
            }
            FontType.NORMAL ->{
                typeface = Typeface.create(resources.getFont(R.font.nuby_semibold), Typeface.NORMAL)
            }
            FontType.BOLD ->{
                typeface = Typeface.create(resources.getFont(R.font.nuby_bold), Typeface.BOLD_ITALIC)
            }
            FontType.EXTRA_BOLD ->{
                typeface = Typeface.create(resources.getFont(R.font.nuby_extrabold), Typeface.BOLD_ITALIC)
            }
            FontType.ITALIC ->{
                typeface = Typeface.create(resources.getFont(R.font.nuby_light), Typeface.ITALIC)
            }
        }
    }

}