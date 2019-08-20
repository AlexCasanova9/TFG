package com.uc3m.foodanalyzerbot.presentation.home.activities

import com.uc3m.foodanalyzerbot.R
import com.uc3m.foodanalyzerbot.infrastructure.ContentView
import com.uc3m.foodanalyzerbot.presentation.common.BaseActivity
import com.uc3m.foodanalyzerbot.presentation.home.fragments.ChatBotFragment
import kotlinx.android.synthetic.main.activity_home.*

@ContentView(R.layout.activity_home)
class HomeActivity : BaseActivity() {

    override fun initializeView() {
        setSupportActionBar(toolbar)
        initFragmentContainer(R.id.fragmentContainer, ChatBotFragment.getInstance())
    }
}
