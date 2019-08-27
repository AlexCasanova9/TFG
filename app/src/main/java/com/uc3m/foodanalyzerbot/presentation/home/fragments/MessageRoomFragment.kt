package com.uc3m.foodanalyzerbot.presentation.home.fragments

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.uc3m.foodanalyzerbot.R
import com.uc3m.foodanalyzerbot.infrastructure.App
import com.uc3m.foodanalyzerbot.infrastructure.ContentView
import com.uc3m.foodanalyzerbot.presentation.common.BaseFragment
import com.uc3m.foodanalyzerbot.presentation.home.adapters.MessageAdapter
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto
import com.uc3m.foodanalyzerbot.presentation.home.presenter.ChatBotPresenter
import com.uc3m.foodanalyzerbot.presentation.home.presenter.ChatBotPresenterImpl
import com.uc3m.foodanalyzerbot.presentation.home.presenter.MessageRoomPresenter
import com.uc3m.foodanalyzerbot.presentation.home.presenter.MessageRoomPresenterImpl
import com.uc3m.foodanalyzerbot.presentation.home.view.MessageRoomView
import kotlinx.android.synthetic.main.fragment_message_room.*
import java.util.*

@ContentView(R.layout.fragment_message_room)
class MessageRoomFragment : BaseFragment(), MessageRoomView {


    companion object {
        fun getInstance() = MessageRoomFragment()
    }

    private var adapter: MessageAdapter? = null
    private val presenter: MessageRoomPresenter = MessageRoomPresenterImpl()

    override fun initializeView() {

        adapter = context?.let { MessageAdapter(it) }
        messageList.adapter = adapter

        SendBtn.setOnClickListener {
            if (MessageText.text.isNotEmpty()) {
                val message = MessageDto(
                    App.user,
                    MessageText.text.toString(),
                    Calendar.getInstance().timeInMillis
                )

                adapter?.addMessage(message)
                presenter.onClickSend(MessageText.text.toString())
            }
        }
    }


    override fun showMessage(message: MessageDto) {
        adapter?.addMessage(message)
    }


}