package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.regex.Pattern

class MinimumAlphaCharactersRule(private val newPassword: String , private val minimumAlphaCharacters: Int): PasswordPolicy {

    override fun isValid(): Boolean {
        val minimumAlphaCharactersRegex = Pattern.compile(("(?:[^a-zA-Z]*[a-zA-Z]){${minimumAlphaCharacters},}"))
        val matcher = minimumAlphaCharactersRegex.matcher(newPassword)
        return matcher.matches()
    }
}
