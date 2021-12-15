package com.icuxika.kt.framework.extensions

import java.security.MessageDigest

fun ByteArray.toHexString(): String = buildString {
    this@toHexString.forEach {
        append("%02X".format(it))
    }
}

fun ByteArray.toMD5(): String =
    MessageDigest.getInstance("MD5").digest(this).toHexString()