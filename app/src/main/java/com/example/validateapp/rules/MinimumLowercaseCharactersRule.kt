package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.regex.Pattern

class MinimumLowercaseCharactersRule(
        private val newPassword: String, private val minimumLowercaseCharactersRule: Int
):PasswordPolicy{

    override fun isValid(): Boolean {
        val minimumLowercaseCharactersRegex = Pattern.compile(("^(?:[^a-z]*[a-z]){${minimumLowercaseCharactersRule},}"))
        val matcher = minimumLowercaseCharactersRegex.matcher(newPassword)
        return matcher.matches()
    }

}