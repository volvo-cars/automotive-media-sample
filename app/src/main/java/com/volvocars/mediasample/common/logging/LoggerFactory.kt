package com.volvocars.mediasample.common.logging

object LoggerFactory {
    private val logger by lazy { AndroidLogger() }

    fun create(): Logger = logger
}
