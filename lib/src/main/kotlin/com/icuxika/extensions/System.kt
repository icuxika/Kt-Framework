package com.icuxika.extensions

import java.nio.file.Paths

enum class OS {
    WINDOWS, LINUX, MACOS, OTHER
}

fun getOsName(): String = System.getProperty("os.name")
fun getUserHome(): String = System.getProperty("user.home")

fun getOs(): OS {
    val osName = getOsName().lowercase()
    return when {
        osName.contains("win") -> OS.WINDOWS
        osName.contains("nux") || osName.contains("nix") -> OS.LINUX
        osName.contains("mac") -> OS.MACOS
        else -> OS.OTHER
    }
}

fun isWindows() = getOs() == OS.WINDOWS
fun isLinux() = getOs() == OS.LINUX
fun isMacOS() = getOs() == OS.MACOS

/**
 * 通用缓存路径前缀
 */
fun cacheDirectory(applicationName: String): String {
    val userHome = getUserHome()
    var path = when (getOs()) {
        OS.WINDOWS -> Paths.get(System.getenv("LOCALAPPDATA"))
        OS.LINUX -> Paths.get(userHome)
        OS.MACOS -> Paths.get(userHome, "/Library/Application Support")
        else -> Paths.get(userHome)
    }
    path = path.resolve(applicationName)
    return path.toString()
}