package com.mohit.androidcleanarchitectureboilerplate.util.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mohit.androidcleanarchitectureboilerplate.databinding.TextInputDialogBinding
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

// Function to show an alert dialog
suspend fun Context.showAlertDialog(
    title: String,
    message: String = "",
    positiveButtonText: String,
    negativeButtonText: String = "Cancel",
) = suspendCoroutine<Boolean> {
    val dialog = MaterialAlertDialogBuilder(this).apply {
        setTitle(title)
        if (message.isNotEmpty())
            setMessage(message)
        setPositiveButton(positiveButtonText) { _, _ ->
            it.resume(true)
        }
        setNegativeButton(negativeButtonText) { _, _ ->
            it.resume(false)
        }
    }
    dialog.show()
}

// Function to show a toast message
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


suspend fun Context.showInputDialog(
    title: String,
    text: String = "",
    placeholder: String,
    label: String,
) = suspendCoroutine<String> {
    val binding = TextInputDialogBinding.inflate(LayoutInflater.from(this)).apply {
        nameTIET.setText(text)
        nameTIL.placeholderText = placeholder
        nameTIL.hint = label
    }

    MaterialAlertDialogBuilder(this).apply {
        setTitle(title)
        setView(binding.root)
        setPositiveButton("Confirm") { _, _ ->
            it.resume(binding.nameTIET.text.toString())
        }
        setNegativeButton("Cancel") { _, _ ->
            it.resume(text)
        }
        show()
    }
}

suspend fun Context.showSelectItemDialog(
    title: String,
    items: List<String>,
) = suspendCoroutine<String?> {
    var selectedItemIndex = 0
    MaterialAlertDialogBuilder(this).apply {
        setTitle(title)
        setSingleChoiceItems(items.toTypedArray(), 0) { _, pos ->
            selectedItemIndex = pos
        }
        setNegativeButton("Cancel") { _, _ -> it.resume(null) }
        setPositiveButton("Confirm") { _, _ ->
            it.resume(items[selectedItemIndex])
        }
        show()
    }
}

fun Context.openBrowser(url: String) {
    Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
        startActivity(it)
    }
}