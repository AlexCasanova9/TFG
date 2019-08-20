package com.uc3m.foodanalyzerbot.presentation.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.uc3m.foodanalyzerbot.infrastructure.ContentView

abstract class BaseActivity : AppCompatActivity() {

    protected fun initFragmentContainer(containerId: Int, fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        javaClass.getAnnotation(ContentView::class.java)?.value?.let {
            if (it != 0)
                setContentView(it)
        }

        ButterKnife.bind(this)

        initializeView()

    }

    protected abstract fun initializeView()
}