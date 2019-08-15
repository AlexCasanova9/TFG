package com.example.foodanalyzerbot.presentation.home.fragments

import com.example.foodanalyzerbot.R
import com.example.foodanalyzerbot.infrastructure.ContentView
import com.example.foodanalyzerbot.presentation.common.BaseFragment
import com.example.foodanalyzerbot.presentation.home.presenter.ChatBotPresenter
import com.example.foodanalyzerbot.presentation.home.presenter.ChatBotPresenterImpl
import com.example.foodanalyzerbot.presentation.home.view.ChatBotView
import com.example.foodanalyzerbot.presentation.utils.loadImageFromUrl
import kotlinx.android.synthetic.main.fragment_chat_bot.*
import java.util.*

@ContentView(R.layout.fragment_chat_bot)
class ChatBotFragment : BaseFragment(), ChatBotView {

    private val presenter: ChatBotPresenter = ChatBotPresenterImpl()

    companion object {
        fun getInstance() = ChatBotFragment()
    }

    override fun initializeView() {
        presenter.initialize(this)
        assignClickListener()
        presenter.loadRandomBackground()
    }

    private fun assignClickListener() {
        PButton.setOnClickListener {
            presenter.onClickPButton()
        }

        WPButton.setOnClickListener {
            presenter.onClickRandomWallpaper()
        }
    }


    override fun setBackgroundImage(resource: Int) {
        val list = ArrayList<String>()
        list.addAll(listOf(*resources.getStringArray(R.array.wallpapers_url)))

        wallpaper.loadImageFromUrl(list[0], R.drawable.chuche)
    }
}