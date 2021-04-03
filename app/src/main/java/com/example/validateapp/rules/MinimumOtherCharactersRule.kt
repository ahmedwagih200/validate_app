package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.*
import java.util.regex.Pattern

class MinimumOtherCharactersRule(
        private val newPassword: String, private val specialCharacters: String , private val minimumOtherCharacters: Int
):PasswordPolicy {

    override fun isValid(): Boolean {
        val chars = "\\Q${specialCharacters}\\E0-9"

        val minimumOtherCharactersRuleRegex = Pattern
                .compile(String.format(Locale.US, "^(?:[^%s]*[%s]){%d,}", chars, chars, minimumOtherCharacters))
        val matcher = minimumOtherCharactersRuleRegex.matcher(newPassword)
        return matcher.matches()
    }
}
