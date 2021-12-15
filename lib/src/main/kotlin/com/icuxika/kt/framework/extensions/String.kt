package com.icuxika.kt.framework.extensions

fun String.queryToMap(): Map<String, String> =
    try {
        this.split("&").associate {
            val (key, value) = it.split("=")
            key to value
        }
    } catch (e: Exception) {
        HashMap()
    }