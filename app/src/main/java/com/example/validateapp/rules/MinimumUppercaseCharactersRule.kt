package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.regex.Pattern

class MinimumUppercaseCharactersRule(private val newPassword: String , private val minimumUppercaseCharacters: Int): PasswordPolicy {

    override fun isValid(): Boolean {
        val upperCaseOccurRegex = Pattern.compile(("^(?:[^A-Z]*[A-Z]){${minimumUppercaseCharacters},}"))
        return upperCaseOccurRegex.matcher(newPassword).find()
    }
}
