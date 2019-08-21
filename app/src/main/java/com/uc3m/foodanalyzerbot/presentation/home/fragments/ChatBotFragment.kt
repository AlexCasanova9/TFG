package com.uc3m.foodanalyzerbot.presentation.home.fragments

import com.uc3m.foodanalyzerbot.R
import com.uc3m.foodanalyzerbot.infrastructure.ContentView
import com.uc3m.foodanalyzerbot.presentation.common.BaseFragment
import com.uc3m.foodanalyzerbot.presentation.home.presenter.ChatBotPresenter
import com.uc3m.foodanalyzerbot.presentation.home.presenter.ChatBotPresenterImpl
import com.uc3m.foodanalyzerbot.presentation.home.view.ChatBotView
import com.uc3m.foodanalyzerbot.presentation.utils.loadImageFromUrl
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
        StartBtn.setOnClickListener {
            presenter.onClickPButton()
        }

        WallpaperBtn.setOnClickListener {
            presenter.onClickRandomWallpaper()
        }
    }


    override fun setBackgroundImage(resource: Int) {
        val list = ArrayList<String>()
        list.addAll(listOf(*resources.getStringArray(R.array.wallpapers_url)))

        wallpaper.loadImageFromUrl(list[resource], R.drawable.uva)
    }
}