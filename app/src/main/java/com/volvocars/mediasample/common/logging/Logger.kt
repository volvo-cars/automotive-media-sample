package com.volvocars.mediasample.common.logging

interface Logger {
    fun debug(tag: String, message: String)
    fun info(tag: String, message: String)
    fun warning(tag: String, message: String)
    fun error(tag: String, message: String)
    fun error(tag: String, message: String? = null, throwable: Throwable)
}
