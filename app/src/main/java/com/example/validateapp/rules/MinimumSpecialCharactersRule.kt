package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy
import java.util.*
import java.util.regex.Pattern

class MinimumSpecialCharactersRule(
        private val newPassword :String , private val spacialChars:String , private val minimumSpecialCharacters: Int): PasswordPolicy {

    override fun isValid(): Boolean {
        val minimumSpecialCharactersRuleRegex = Pattern
                .compile(String.format(
                        Locale.US, "(?:[^\\Q\\%s\\E]*[\\Q\\%s\\E]){%d,}", spacialChars, spacialChars, minimumSpecialCharacters))
        val matcher = minimumSpecialCharactersRuleRegex.matcher(newPassword)
        return matcher.matches()
    }

}
