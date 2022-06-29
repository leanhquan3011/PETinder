package com.leaquan.petinder.util.type

enum class EnumValue (val type : Int) {
    TITLE(1),
    NORMAL(2),
    BOLD(3),
    EXTRA_BOLD(4),
    ITALIC(5);


    companion object {
        fun valueOf(typeValue: Int): EnumValue {
            return when(typeValue){
                1->{
                    TITLE
                }
                2->{
                    NORMAL
                }
                3->{
                    BOLD
                }
                4->{
                    EXTRA_BOLD
                }
                5->{
                    ITALIC
                }

                else -> NORMAL
            }
        }
    }
}
