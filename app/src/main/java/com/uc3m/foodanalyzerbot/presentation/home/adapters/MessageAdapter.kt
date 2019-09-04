package com.uc3m.foodanalyzerbot.presentation.home.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.uc3m.foodanalyzerbot.R
import com.uc3m.foodanalyzerbot.infrastructure.App
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto
import com.uc3m.foodanalyzerbot.presentation.utils.Formatter
import kotlinx.android.synthetic.main.item_message_bot.view.*
import kotlinx.android.synthetic.main.item_message_person.view.*
import java.util.*

class MessageAdapter(private val context: Context) : RecyclerView.Adapter<MessageViewHolder>() {

    companion object {
        private const val VIEW_TYPE_PERSON_MESSAGE = 1
        private const val VIEW_TYPE_BOT_MESSAGE = 2
    }

    private val messages: ArrayList<MessageDto> = ArrayList()


    fun addMessage(message: MessageDto) {
        messages.add(message)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        val message = messages[position]

        return if (App.getPreferences().getUserName() == message.user) {
            VIEW_TYPE_PERSON_MESSAGE
        } else {
            VIEW_TYPE_BOT_MESSAGE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return if (viewType == VIEW_TYPE_PERSON_MESSAGE) {
            MyMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_person, parent, false))
        } else {
            BotMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_bot, parent, false))
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message)
    }

    inner class MyMessageViewHolder (view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.userMessage
        private var userName: TextView = view.userName
        private var timeText: TextView = view.userTimestamp

        override fun bind(message: MessageDto) {
            messageText.text = message.message
            userName.text = App.getPreferences().getUserName()
            setUnderlineText(timeText, Formatter.formatHour(message.time))
        }
    }


    inner class BotMessageViewHolder (view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.botMessage
        private var botName: TextView = view.botName
        private var timeText: TextView = view.botTimestamp

        override fun bind(message: MessageDto) {
            messageText.text = message.message
            botName.text = message.user
            setUnderlineText(timeText, Formatter.formatHour(message.time))
        }
    }

    private fun setUnderlineText(textView: TextView, text: String) {
        val spannableString = SpannableString(text)
        spannableString.setSpan(
            UnderlineSpan(),
            0,
            spannableString.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannableString
    }
}

open class MessageViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(message: MessageDto) = Unit
}

