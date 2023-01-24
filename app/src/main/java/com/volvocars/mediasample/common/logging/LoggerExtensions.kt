/*
 * Copyright 2022 Volvo Car Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.volvocars.mediasample.common.logging

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
