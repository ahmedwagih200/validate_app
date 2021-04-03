package com.example.validateapp.api

import com.example.validateapp.data.Rules
import com.example.validateapp.rules.*
import java.util.*
import kotlin.collections.ArrayList

class RulesBuilder(private val rules: Rules, private val newPassword: String, private val oldPassword: String) {

    private val rulesList = arrayListOf<PasswordPolicy?>()

    fun createPasswordPolicy() : ArrayList<PasswordPolicy?>{

        rulesList.add(addMaximumConsecutiveRepeatedCharactersRule())

        rulesList.add(addMaximumLengthRule())

        rulesList.add(addMaximumRepeatedCharactersRule())

        rulesList.add(addMinimumAlphaCharactersRule())

        rulesList.add(addMinimumDifferentCharactersRule())

        rulesList.add(addMinimumLengthRule())

        rulesList.add(addMinimumLowercaseCharactersRule())

        rulesList.add(addMinimumNumericCharactersRule())

        rulesList.add(addMinimumOtherCharactersRule())

        rulesList.add(addMinimumSpecialCharactersRule())

        rulesList.add(addMinimumLowercaseCharactersRule())

        rulesList.add(addWhiteSpaceRule())

        rulesList.add(addPasswordHistoryCountRule())

        rulesList.add(addMinimumUppercaseCharactersRule())

        rulesList.add(addMaximumAscendingCharactersRule())

        rulesList.add(addMaximumDescendingCharactersRule())

        rulesList.removeAll(Collections.singleton(null))

        return rulesList

    }

    private fun addMaximumConsecutiveRepeatedCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.maximumConsecutiveRepeatedCharacters))
            MaximumConsecutiveRepeatedCharactersRule(newPassword, rules.maximumConsecutiveRepeatedCharacters)
        else null
    }

    private fun addMaximumLengthRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.maximumLength))
            MaximumLengthRule(newPassword, rules.maximumLength)
        else null
    }

    private fun addMaximumRepeatedCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.maximumRepeatedCharacters))
            MaximumRepeatedCharactersRule(newPassword, rules.maximumRepeatedCharacters)
        else null
    }

    private fun addMinimumAlphaCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumAlphaCharacters))
            MinimumAlphaCharactersRule(newPassword, rules.minimumAlphaCharacters)
        else null
    }

    private fun addMinimumDifferentCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumDifferentCharacters))
            MinimumDifferentCharactersRule(oldPassword, newPassword, rules.minimumDifferentCharacters)
        else null
    }

    private fun addMinimumLengthRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumLength))
            MinimumLengthRule(newPassword, rules.minimumLength)
        else null
    }

    private fun addMinimumLowercaseCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumLowercaseCharacters))
            MinimumLowercaseCharactersRule(newPassword, rules.minimumLowercaseCharacters)
        else null
    }

    private fun addMinimumNumericCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumNumericCharacters))
            MinimumNumericCharactersRule(newPassword, rules.minimumNumericCharacters)
        else null
    }

    private fun addMinimumOtherCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumOtherCharacters) && isValidSpecialCharacterResponse(rules.specialCharacters))
            MinimumOtherCharactersRule(newPassword, rules.specialCharacters, rules.minimumOtherCharacters)
        else null
    }

    private fun addMinimumSpecialCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumSpecialCharacters) && isValidSpecialCharacterResponse(rules.specialCharacters))
            MinimumOtherCharactersRule(newPassword, rules.specialCharacters, rules.minimumSpecialCharacters)
        else null
    }

    private fun addMinimumUppercaseCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.minimumUppercaseCharacters))
            MinimumUppercaseCharactersRule(newPassword, rules.minimumUppercaseCharacters)
        else null
    }

    private fun addPasswordHistoryCountRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.passwordHistoryCount))
            PasswordHistoryCountRule(oldPassword, newPassword)
        else null
    }


    private fun addWhiteSpaceRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.whitespaceAllowed))
            WhiteSpaceRule(newPassword, rules.whitespaceAllowed)
        else null
    }

    private fun addMaximumAscendingCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.maximumAscendingCharacters))
            MaximumAscendingCharactersRule(newPassword, rules.maximumAscendingCharacters)
        else null
    }

    private fun addMaximumDescendingCharactersRule(): PasswordPolicy? {
        return if (isValidRuleResponse(rules.maximumDescendingCharacters))
            MaximumDescendingCharactersRule(newPassword, rules.maximumDescendingCharacters)
        else null
    }

    private fun isValidRuleResponse(rule: Int?): Boolean {
        return rule != null && rule >= 0
    }

    private fun isValidRuleResponse(rule: Boolean?): Boolean {
        return rule != null && !rule
    }

    private fun isValidSpecialCharacterResponse(specialCharResponse: String?): Boolean {
        return specialCharResponse != null
    }
}
