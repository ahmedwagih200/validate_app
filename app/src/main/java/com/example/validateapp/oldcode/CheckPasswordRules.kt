//package com.example.validateapp.api
//
//import com.example.validateapp.data.Rules
//import java.util.regex.Pattern
//
//class CheckPasswordRules(private val rules: Rules, private val listener: CheckForPass, private val oldPass: String, private val newPass: String) {
//
//    private var errorString = " Password cannot have . "
//    private var list = arrayListOf<Boolean>()
//    var passwordIsWrong: Boolean = false
//
//    fun validateThePass() {
//        list.add(maximumConsecutiveRepeatedCharactersRule(newPass))
//        list.add(maximumRepeatedCharactersRule(newPass))
//        list.add(minimumLengthRule(newPass))
//        list.add(maximumLengthRule(newPass))
//
//        for(b in list){
//            if (b){
//                passwordIsWrong = true
//            }
//        }
//
//        if (passwordIsWrong) {
//            listener.checkForPass(true, errorString)
//        } else {
//            listener.checkForPass(false, "Password changed")
//        }
//    }
//
//    private fun maximumConsecutiveRepeatedCharactersRule(newPass: String): Boolean {
//        val consecutiveRepeatedCharsRegex = Pattern.compile(("([\\w\\W])\\1{${rules.maximumConsecutiveRepeatedCharacters},}"))
//        val matcher = consecutiveRepeatedCharsRegex.matcher(newPass)
//        if(matcher.matches()){
//            errorString += " more than ${rules.maximumConsecutiveRepeatedCharacters} ConsecutiveRepeatedCharacters . "
//        }
//        return matcher.matches()
//    }
//
//    private fun maximumLengthRule(newPass: String): Boolean {
//        if (newPass.length > rules.maximumLength) {
//            errorString +=" more than ${rules.maximumLength} Characters . "
//        }
//        return newPass.length > rules.maximumLength
//    }
//
//    private fun minimumLengthRule(newPass: String): Boolean{
//        if (newPass.length < rules.minimumLength) {
//            errorString += " less than ${rules.minimumLength} Characters . "
//        }
//        return newPass.length < rules.minimumLength
//    }
//
//    private fun maximumRepeatedCharactersRule(newPass: String): Boolean{
//        val maximumRepeatedCharsRegex = Pattern.compile(("(.)(?:.*?\\1){${5},}"))
//        val matcher = maximumRepeatedCharsRegex.matcher(newPass)
//        if (matcher.matches()){
//            errorString += " more than ${5} repeated Characters . "
//        }
//        return !matcher.matches()
//    }
//
//    interface CheckForPass {
//        fun checkForPass(isPasswordNotValid: Boolean, string: String)
//    }
//}
