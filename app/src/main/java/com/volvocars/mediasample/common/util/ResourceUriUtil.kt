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
package com.volvocars.mediasample.common.util

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.annotation.AnyRes

class ResourceUriUtil(private val context: Context) {
    fun getUriFor(@AnyRes resId: Int): Uri = Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(context.resources.getResourcePackageName(resId))
            .path(context.resources.getResourceTypeName(resId))
            .appendPath(context.resources.getResourceEntryName(resId))
            .build()
}
