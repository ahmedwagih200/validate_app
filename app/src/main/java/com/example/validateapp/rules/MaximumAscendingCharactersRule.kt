package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy

class MaximumAscendingCharactersRule(private val newPassword: String, private val maximumAscendingRepeatedChars: Int ): PasswordPolicy{

    override fun isValid(): Boolean {

        val passwordBytes = newPassword.toByteArray()
        var repeatedCharsCount = 1
        for (i in passwordBytes.indices) {
            if (i != passwordBytes.size - 1) {
                val first = passwordBytes[i].toInt()
                val second = passwordBytes[i + 1] - 1
                if (first == second) {
                    repeatedCharsCount++
                    if (repeatedCharsCount > maximumAscendingRepeatedChars - 1) return false
                } else repeatedCharsCount = 1
            }
        }
        return true
    }
}
