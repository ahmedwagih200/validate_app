package com.example.validateapp.data

data class Rules(
    val minimumLength : Int =0,
    val maximumLength : Int =0,
    val minimumAlphaCharacters : Int=0 ,
    val minimumNumericCharacters : Int=0 ,
    val minimumSpecialCharacters : Int=0 ,
    val minimumLowercaseCharacters : Int=0 ,
    val minimumUppercaseCharacters : Int=0 ,
    val minimumDifferentCharacters : Int=0 ,
    val minimumOtherCharacters : Int=0 ,
    val maximumRepeatedCharacters : Int=0 ,
    val maximumConsecutiveRepeatedCharacters : Int=0 ,
    val maximumAscendingCharacters : Int=0 ,
    val maximumDescendingCharacters : Int=0,
    val passwordHistoryCount : Int=0 ,
    val canContainUserId : Boolean= true ,
    val specialCharacters : String = "" ,
    val whitespaceAllowed : Boolean= true
)