package com.leaquan.petinder.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.leaquan.petinder.base.view.BaseView

abstract class BaseFragment <DB : ViewDataBinding> : androidx.fragment.app.Fragment(), BaseView {

    open lateinit var binding : DB

    @LayoutRes
    abstract fun inflateLayout(): Int

    override fun provideContext(): Context? = requireContext()

    override fun provideRootView(): View? = view

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,inflateLayout(),container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        setUpObserver()
    }
}