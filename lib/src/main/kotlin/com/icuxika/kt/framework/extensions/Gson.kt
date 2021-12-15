package com.icuxika.kt.framework.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T : Any> Gson.fromJson(json: String): T? {
    return try {
        fromJson<T>(json, object : TypeToken<T>() {}.type)
    } catch (e: Exception) {
        null
    }
}