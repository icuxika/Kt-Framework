package com.icuxika.kt.framework.extensions

import com.icuxika.kt.framework.extensions.newFile
import kotlin.test.Test
import kotlin.test.assertTrue

class FileTest {

    @Test
    fun createFile() {
        assertTrue("/Users/icuxika/Downloads/temp/test.txt".newFile().exists(), "文件创建失败")
    }
}