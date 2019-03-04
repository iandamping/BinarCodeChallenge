package com.example.junemon.binarchallengecode.utils

import android.text.Editable
import android.widget.EditText

fun EditText.clear() {
    this.text = Editable.Factory.getInstance().newEditable("")
}

fun EditText.requestError(message: String?) {
    if (this.text.isNullOrEmpty()) {
        this.requestFocus()
        this.error = message
    }

}