package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.regex.Pattern

class MaximumConsecutiveRepeatedCharactersRule(
        private val newPassword: String, private val maximumConsecutiveRepeatedCharacters: Int
) : PasswordPolicy {

    override fun isValid(): Boolean {
        val consecutiveRepeatedCharsRegex = Pattern.compile(("([\\w\\W])\\1{${maximumConsecutiveRepeatedCharacters},}"))
        val matcher = consecutiveRepeatedCharsRegex.matcher(newPassword)
        return !matcher.matches()
    }
}
