package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.regex.Pattern

class MinimumNumericCharactersRule(private val newPassword: String, private val minimumNumericCharacters: Int): PasswordPolicy{
    override fun isValid(): Boolean {
        val minimumNumericCharactersRegex = Pattern.compile(("(?:[^0-9]*[0-9]){${minimumNumericCharacters},}"))
        val matcher = minimumNumericCharactersRegex.matcher(newPassword)
        return matcher.matches()
    }
}