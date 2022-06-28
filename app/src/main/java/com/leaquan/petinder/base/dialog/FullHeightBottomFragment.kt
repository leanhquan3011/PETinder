package com.leaquan.petinder.base.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//TODO research this
open class FullHeightBottomFragment : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return object : BottomSheetDialog(requireContext(), theme){

            override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

                val view: View? = currentFocus
                val ret = super.dispatchTouchEvent(ev)
                //click out -> close
                if (view is EditText) {
                    currentFocus?.let {
                        val w: View = it
                        val scrcoords = IntArray(2)
                        w.getLocationOnScreen(scrcoords)
                        val x: Float = ev.rawX + w.left - scrcoords[0]
                        val y: Float = ev.rawY + w.top - scrcoords[1]
                        if (ev.action == MotionEvent.ACTION_UP
                            && (x < w.left || x >= w.right || y < w.top || y > w.bottom)
                        ) {
                            view.let {
                                val inputMethodManager = requireContext().getSystemService(
                                    Context.INPUT_METHOD_SERVICE
                                ) as InputMethodManager
                                inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
                            }
                        }
                    }
                }
                //
                return ret
            }
        }

    }

}