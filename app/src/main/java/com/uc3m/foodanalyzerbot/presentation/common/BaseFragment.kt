package com.uc3m.foodanalyzerbot.presentation.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.uc3m.foodanalyzerbot.infrastructure.ContentView

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewId = getFragmentContentView()
        if (viewId == 0) return null
        val view = inflater.inflate(getFragmentContentView(), container, false)
        ButterKnife.bind(this, view)
        return view
    }

    private fun getFragmentContentView(): Int {
        val annotation = javaClass.getAnnotation(ContentView::class.java)
        return annotation?.value ?: 0
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeView()
    }

    protected abstract fun initializeView()
}