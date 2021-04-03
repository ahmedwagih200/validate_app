package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy

class MinimumDifferentCharactersRule(
        private val oldPassword: String, private val newPassword: String, private val minimumDifferentCharactersRule:Int
): PasswordPolicy {

    override fun isValid(): Boolean {

        val oldPasswordSet: MutableSet<Char> = HashSet()
        val newPasswordSet: MutableSet<Char> = HashSet()

        for (c in oldPassword.toCharArray()) oldPasswordSet.add(c)

        for (c in newPassword.toCharArray()) newPasswordSet.add(c)

        val unionSet: MutableSet<Char> = HashSet()
        unionSet.addAll(oldPasswordSet)
        unionSet.addAll(newPasswordSet)
        unionSet.removeAll(oldPasswordSet)

        return unionSet.size >= minimumDifferentCharactersRule
    }
}