package com.uc3m.foodanalyzerbot.presentation.common

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import butterknife.ButterKnife
import com.uc3m.foodanalyzerbot.infrastructure.ContentView

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

    protected fun hideKeyboard() {
        val focus = activity?.currentFocus ?: return
        val inputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(focus.windowToken, 0)
    }

    protected fun showKeyBoard(focus: View?) {
        if (focus == null) return
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(focus, InputMethodManager.SHOW_IMPLICIT)
    }
}