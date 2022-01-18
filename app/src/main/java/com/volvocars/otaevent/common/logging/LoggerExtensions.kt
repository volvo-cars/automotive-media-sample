package com.volvocars.otaevent.common.logging

fun Any.logd(message: String) {
    LoggerFactory.create().debug(logTag(), message)
}

fun Any.logi(message: String) {
    LoggerFactory.create().info(logTag(), message)
}

fun Any.logw(message: String) {
    LoggerFactory.create().warning(logTag(), message)
}

fun Any.loge(message: String) {
    LoggerFactory.create().error(logTag(), message)
}

fun Any.loge(message: String? = null, throwable: Throwable) {
    LoggerFactory.create().error(logTag(), message, throwable)
}

fun Any.logTag(): String = javaClass.simpleName
