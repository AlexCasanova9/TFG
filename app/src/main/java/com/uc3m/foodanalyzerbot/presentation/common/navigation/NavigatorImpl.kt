package com.uc3m.foodanalyzerbot.presentation.common.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.uc3m.foodanalyzerbot.R
import com.uc3m.foodanalyzerbot.presentation.home.fragments.MessageRoomFragment
import com.uc3m.foodanalyzerbot.presentation.home.fragments.NameDialogFragment

class NavigatorImpl(private var context: Context) : Navigator {

    private fun startActivity(intent: Intent) {
        context.startActivity(intent)
    }

    private fun showFragment(containerId: Int, fragment: Fragment, backEnable: Boolean) {
        val transaction = getFragmentManager().beginTransaction()
        val fragmentTag = fragment.javaClass.simpleName
        transaction.replace(containerId, fragment, fragmentTag)

        if (backEnable) {
            transaction.addToBackStack(fragmentTag)
        }
        transaction.commit()
    }

    private fun addFragment(containerId: Int, fragment: Fragment, backEnable: Boolean?, hidePreviousFragment: Boolean) {
        val transaction = getFragmentManager().beginTransaction()
        if (hidePreviousFragment) {
            val currentFragment = getFragmentManager().findFragmentById(containerId)
            if (currentFragment != null)
                transaction.hide(currentFragment)
        }

        transaction.add(containerId, fragment)

        if (backEnable!!) {
            val fragmentTag = fragment.javaClass.simpleName
            transaction.addToBackStack(fragmentTag)
        }
        transaction.commit()
    }

    private fun getFragmentManager(): FragmentManager {
        return (context as FragmentActivity).supportFragmentManager
    }

    override fun showMessageRoom() {
        showFragment(R.id.fragmentContainer, MessageRoomFragment.getInstance(), false)
    }

    override fun showNameDialog() {
        showFragment(R.id.fragmentContainer, NameDialogFragment.newInstance(), true)
    }
}