package com.icuxika.extensions

import kotlin.test.Test
import kotlin.test.assertTrue

class FileTest {

    @Test
    fun createFile() {
        assertTrue("/Users/icuxika/Downloads/temp/test.txt".newFile().exists(), "文件创建失败")
    }
}