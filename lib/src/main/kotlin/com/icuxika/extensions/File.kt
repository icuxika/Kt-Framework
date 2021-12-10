package com.icuxika.extensions

import java.io.File
import java.io.InputStream
import java.nio.file.Paths

/**
 * 创建文件（源文件存在则先删除）
 */
fun createNewFile(directory: String, name: String): File {
    File(directory).also { it.mkdirs() }.path.let { path ->
        Paths.get(path, name).toFile().let { file ->
            file.createNewFile().let {
                if (!it) {
                    file.delete()
                    file.createNewFile()
                }
            }
            return file
        }
    }
}

fun InputStream.toFile(directory: String, name: String) =
    createNewFile(directory, name).outputStream().use { copyTo(it) }

fun String.newFileSaveTo(directory: String) = createNewFile(directory, this)
fun String.newFileNamed(name: String) = createNewFile(this, name)

/**
 * 根据完整的文件路径创建文件
 */
fun String.newFile(): File {
    File(this).let { file ->
        file.parent?.let { directory ->
            createNewFile(directory, file.name)
        } ?: run {
            throw RuntimeException("请确保文件中至少存在一个[${File.separator}]")
        }
        return file
    }
}