package com.example.validateapp.rules

import com.example.validateapp.api.PasswordPolicy

class PasswordHistoryCountRule(private val oldPassword: String , private val newPassword:String) : PasswordPolicy {

    override fun isValid(): Boolean {
        return oldPassword != newPassword;
    }
}