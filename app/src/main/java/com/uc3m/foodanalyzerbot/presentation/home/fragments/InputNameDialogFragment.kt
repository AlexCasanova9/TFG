package com.uc3m.foodanalyzerbot.presentation.home.fragments

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.uc3m.foodanalyzerbot.infrastructure.App
import kotlinx.android.synthetic.main.fragment_dialog_input_user_name.*
import java.util.*


class InputNameDialogFragment : DialogFragment() {
    companion object {
        fun newInstance() = InputNameDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            com.uc3m.foodanalyzerbot.R.layout.fragment_dialog_input_user_name,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name_editText.requestFocus()
        //Show Soft KeyBoard
        val inputMethodManager =
            context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        accept_button.setOnClickListener {
            val name: String = name_editText.text.toString().toUpperCase(Locale.getDefault())
            Toast.makeText(activity, "Hola: $name!", Toast.LENGTH_LONG).show()
            App.getPreferences().setUserName(name)
            dismiss()
        }

    }


}