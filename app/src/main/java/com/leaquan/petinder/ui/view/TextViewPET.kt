package com.leaquan.petinder.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.annotation.StyleRes
import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R
import com.leaquan.petinder.util.type.EnumValue

class TextViewPET : androidx.appcompat.widget.AppCompatTextView {

    constructor(context: Context): super(context){
        init(context, null)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs){
        init(context, attrs)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewPET)
        val textStyle = typedArray.getInt(R.styleable.TextViewPET_fontType, EnumValue.NORMAL.type)
        setTitleStyle(EnumValue.valueOf(textStyle))
        typedArray.recycle()
    }

    fun setFontType(@StyleRes fontType: Int){
        setTypeface(typeface, fontType)
    }

    fun setTitleStyle(style: EnumValue){

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