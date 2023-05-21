package com.example.navapp1

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.navapp1.databinding.FragBinding

class DialogFragmentExample : DialogFragment() {
    private lateinit var sendNotification: FragBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_notif, null)

        sendNotification = FragBinding.inflate(layoutInflater)
        val editText = dialogView.findViewById<EditText>(R.id.editTextTextPersonName)

        builder.setView(dialogView)
            .setMessage("Enter a value")
            .setPositiveButton("OK") { dialog, id ->
                val inputText = editText.text.toString()
                dismiss()
                val intent = Intent(activity, MainActivity3::class.java)
                intent.putExtra("progBarLauncher", inputText)
                startActivity(intent)
            }
            .setNegativeButton("CANCEL") { dialog, id ->
                dismiss()
            }

        return builder.create()
    }
}
