package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy

class MinimumLengthRule(private val newPassword: String, private val minimumLength: Int): PasswordPolicy{

    override fun isValid(): Boolean {
        return newPassword.length >= minimumLength
    }

}
