package com.example.foodanalyzerbot.presentation.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.foodanalyzerbot.R
import com.example.foodanalyzerbot.infrastructure.App
import kotlinx.android.synthetic.main.bot_message.view.*
import kotlinx.android.synthetic.main.my_message.view.*

import java.text.SimpleDateFormat
import java.util.*


private const val VIEW_TYPE_MY_MESSAGE = 1
private const val VIEW_TYPE_BOT_MESSAGE = 2

object DateUtils {
    fun fromMillisToTimeString(millis: Long) : String {
        val format = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return format.format(millis)
    }
}
/*
class MessageAdapter (val context: Context) : RecyclerView.Adapter<MessageViewHolder>() {
    private val messages: ArrayList<Message> = ArrayList()

    fun addMessage(message: Message){
        messages.add(message)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        val message = messages.get(position)

        return if(App.user == message.user) {
            VIEW_TYPE_MY_MESSAGE
        } else {
            VIEW_TYPE_BOT_MESSAGE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return if(viewType == VIEW_TYPE_MY_MESSAGE) {
            MyMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.my_message, parent, false))
        } else {
            BotMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.bot_message, parent, false))
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages.get(position)

        holder?.bind(message)
    }

    inner class MyMessageViewHolder (view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.UserText
        private var timeText: TextView = view.UserTime

        override fun bind(message: Message) {
            messageText.text = message.message
            timeText.text = DateUtils.fromMillisToTimeString(message.time)
        }
    }


    inner class BotMessageViewHolder (view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.BotText
        private var userText: TextView = view.BotName
        private var timeText: TextView = view.BotTime

        override fun bind(message: Message) {
            messageText.text = message.message
            userText.text = message.user
            timeText.text = DateUtils.fromMillisToTimeString(message.time)
        }
    }
}

open class MessageViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(message:Message) {}
}
*/