package com.example.android.testing.unittesting.BasicSample

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

/**
 * Created by lenovo on 3/29/2019.
 */
class PasswordValidator : TextWatcher {

    internal var isValid = false

    override fun afterTextChanged(s: Editable?) {
        isValid = isPasswordValid(s);
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    companion object {
        var regex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,}\$"

        fun isPasswordValid(password: CharSequence?): Boolean{
            return password!=null && Pattern.matches(regex,password)
        }
    }



}