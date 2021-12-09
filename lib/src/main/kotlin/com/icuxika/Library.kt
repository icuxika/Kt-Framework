package com.icuxika

import com.icuxika.extensions.logger

class Library {
    fun someLibraryMethod(): Boolean {
        L.info("someLibraryMethod 执行")
        return true
    }

    companion object {
        val L = logger()
    }
}
