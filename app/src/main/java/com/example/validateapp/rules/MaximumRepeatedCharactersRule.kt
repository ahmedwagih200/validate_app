package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.regex.Pattern

class MaximumRepeatedCharactersRule (private val newPassword: String, private val maximumRepeatedCharacters: Int): PasswordPolicy{
    override fun isValid(): Boolean {
        val maximumRepeatedCharsRegex = Pattern.compile(("(.)(?:.*?\\1){${maximumRepeatedCharacters},}"))
        val matcher = maximumRepeatedCharsRegex.matcher(newPassword)
        return !matcher.matches()
    }

}