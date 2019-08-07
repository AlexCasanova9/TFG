package com.example.foodanalyzerbot.presentation.home.activities

import com.example.foodanalyzerbot.R
import com.example.foodanalyzerbot.infrastructure.ContentView
import com.example.foodanalyzerbot.presentation.common.BaseActivity
import com.example.foodanalyzerbot.presentation.home.fragments.ChatBotFragment
import kotlinx.android.synthetic.main.activity_home.*

@ContentView(R.layout.activity_home)
class HomeActivity : BaseActivity() {

    override fun initializeView() {
        setSupportActionBar(toolbar)
        initFragmentContainer(R.id.fragmentContainer, ChatBotFragment.getInstance())
    }
}
