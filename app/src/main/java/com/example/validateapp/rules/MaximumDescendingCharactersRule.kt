package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy

class MaximumDescendingCharactersRule(
        private val newPassword: String, private val maximumDescendingRepeatedChars: Int ): PasswordPolicy {

    override fun isValid(): Boolean {
        val passwordBytes: ByteArray = newPassword.toByteArray()
        var repeatedCharsCount = 1
        for (i in passwordBytes.indices) {
            if (i != passwordBytes.size - 1) {
                val first = passwordBytes[i].toInt()
                val second = passwordBytes[i + 1] + 1
                if (first == second) {
                    repeatedCharsCount++
                    if (repeatedCharsCount > maximumDescendingRepeatedChars - 1) return false
                } else repeatedCharsCount = 1
            }
        }
        return true
    }
}

