package com.leaquan.petinder.ui.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Typeface
import android.util.AttributeSet
import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R
import com.leaquan.petinder.util.type.EnumValue

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
        val textStyle = typedArray.getInt(R.styleable.ButtonPET_fontType, EnumValue.NORMAL.type)
        val isGradientText = typedArray.getBoolean(R.styleable.ButtonPET_gradientText, false)
        setFontType(EnumValue.valueOf(textStyle))
        setGradientText(isGradientText)
        typedArray.recycle()
    }

    private fun setGradientText(gradientText: Boolean) {
        if (gradientText) {
            val paint = this.paint
            val width = paint.measureText(this.text.toString())
            val textShader: Shader = LinearGradient(0f, 0f, width, this.textSize, intArrayOf(
                Color.parseColor("#FF846F"),
                Color.parseColor("#EF80A6")
            ), null, Shader.TileMode.MIRROR)

            this.paint.shader = textShader

            this.setTextColor(PETinderApplication.getResources().getColor(R.color.colorPrimary))
        }
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