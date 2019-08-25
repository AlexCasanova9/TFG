package com.uc3m.foodanalyzerbot.presentation.home.fragments

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.uc3m.foodanalyzerbot.R
import android.view.WindowManager
import android.view.ViewGroup
import android.view.LayoutInflater
import com.uc3m.foodanalyzerbot.infrastructure.App


class NameDialogFragment : DialogFragment() {

    var editName: EditText? = null
    var button: Button? = null


    private var mEditText: EditText? = null

    companion object {

        fun newInstance() = NameDialogFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialogfragment_username, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Get field from view
        mEditText = view.findViewById<View>(R.id.NameText) as EditText

        // Show soft keyboard automatically and request focus to field
        mEditText?.requestFocus()
        dialog.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE

        )

        this.button = view.findViewById(R.id.Accept)

        this.button?.setOnClickListener {

            var a: String = editName?.text.toString()

            Toast.makeText(activity, "User name: " + a, Toast.LENGTH_LONG).show()


         App.getPreferences().setUserName(a)

        }

    }


}