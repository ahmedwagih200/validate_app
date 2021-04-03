package com.example.validateapp.api

class PasswordValidator {

    fun validatePassword(rulesList: ArrayList<PasswordPolicy?>): Boolean{
        for(rule in rulesList){
            if (rule != null) {
                if (!rule.isValid())
                    return false
            }
        }
        return true
    }
}
