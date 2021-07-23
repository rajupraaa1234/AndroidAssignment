package com.example.myloginapp.Dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.androidassignment.R


class ExampleDialog : AppCompatDialogFragment() {
    private var editTextUsername: EditText? = null
    private var listener: ExampleDialogListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(
            requireActivity()
        )
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.add_msg_layout, null)
        builder.setView(view)
            .setCancelable(false)
            .setTitle("Please Enter Your Message")
            .setNegativeButton("cancel") { dialogInterface, i -> }
            .setPositiveButton("ok") { dialogInterface, i ->
                val username = editTextUsername!!.text.toString()
                listener!!.applyTexts(username)
            }
        editTextUsername = view.findViewById(R.id.edit_username)
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as ExampleDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement ExampleDialogListener"
            )
        }
    }

    interface ExampleDialogListener {
        fun applyTexts(username: String?)
    }
}