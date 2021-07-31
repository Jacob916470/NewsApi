package com.jacob.newsapi.presentation.utils

import com.jacob.newsapi.data.utils.Configuration

object FieldValidation {

    private val passwordPattern = Regex(Configuration.PASSWORD_PATTERN)

    fun isPasswordSafe(paswword: String): Boolean = paswword.contains(passwordPattern)

    fun isPasswordLength(paswword: String): Boolean {
        return paswword.length in Configuration.MIN_PASSWORD_LENGTH..Configuration.MAX_PASSWORD_LENGTH
    }
}