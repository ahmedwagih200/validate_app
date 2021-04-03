package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy

class MaximumLengthRule(private val newPassword: String ,private val maximumLength: Int ): PasswordPolicy{

    override fun isValid(): Boolean {
        return newPassword.length <= maximumLength
    }

}
