package com.icuxika.kt.framework

import com.icuxika.kt.framework.extensions.logger

class Library {
    fun someLibraryMethod(): Boolean {
        L.info("someLibraryMethod 执行")
        return true
    }

    companion object {
        val L = logger()
    }
}
