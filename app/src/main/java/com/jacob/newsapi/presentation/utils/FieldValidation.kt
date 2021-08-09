package com.jacob.newsapi.presentation.utils

import com.jacob.newsapi.data.utils.Configurations

object FieldValidation {

    private val passwordPattern = Regex(Configurations.PASSWORD_PATTERN)

    fun isPasswordSafe(paswword: String): Boolean = paswword.contains(passwordPattern)

    fun isPasswordLength(paswword: String): Boolean {
        return paswword.length in Configurations.MIN_PASSWORD_LENGTH..Configurations.MAX_PASSWORD_LENGTH
    }
}