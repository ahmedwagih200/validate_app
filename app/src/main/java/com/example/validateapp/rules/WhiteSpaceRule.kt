package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy

class WhiteSpaceRule(private val newPassword : String , private val whitespaceAllowed: Boolean) : PasswordPolicy {

    override fun isValid(): Boolean {
        return whitespaceAllowed || !newPassword.contains(" ")
    }
}