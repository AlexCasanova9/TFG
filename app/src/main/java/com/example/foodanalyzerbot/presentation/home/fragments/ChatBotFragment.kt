package com.example.foodanalyzerbot.presentation.home.fragments

import android.widget.Toast
import com.example.foodanalyzerbot.R
import com.example.foodanalyzerbot.infrastructure.ContentView
import com.example.foodanalyzerbot.presentation.common.BaseFragment
import com.example.foodanalyzerbot.presentation.home.presenter.ChatBotPresenter
import com.example.foodanalyzerbot.presentation.home.presenter.ChatBotPresenterImpl
import com.example.foodanalyzerbot.presentation.home.view.ChatBotView
import kotlinx.android.synthetic.main.fragment_chat_bot.*

@ContentView(R.layout.fragment_chat_bot)
class ChatBotFragment : BaseFragment(), ChatBotView {

    private val presenter: ChatBotPresenter = ChatBotPresenterImpl()

    companion object {
        fun getInstance() = ChatBotFragment()
    }

    override fun initializeView() {
        presenter.initialize(this)
        assignClickListener()
    }

    private fun assignClickListener() {
        PButton.setOnClickListener {
            Toast.makeText(this.context, "Alex: Button was pressed!", Toast.LENGTH_LONG).show()
        }

        WPButton.setOnClickListener {
            presenter.onClickRandomWallpaper()
        }
    }

    override fun setBackgroundImage(resource: Int) {
        when (resource) {
            1 -> containerLayout.setBackgroundResource(R.drawable.chuche)
            2 -> containerLayout.setBackgroundResource(R.drawable.fruta)
            3 -> containerLayout.setBackgroundResource(R.drawable.manzana)
            4 -> containerLayout.setBackgroundResource(R.drawable.sandia)
            5 -> containerLayout.setBackgroundResource(R.drawable.uva)
        }
    }
}