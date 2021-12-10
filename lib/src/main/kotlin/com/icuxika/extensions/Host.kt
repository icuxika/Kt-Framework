package com.icuxika.extensions

import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketTimeoutException

fun portOccupationDetect(host: String, port: Int) {
    Socket().apply {
        bind(InetSocketAddress(host, port))
    }.close()
}

/**
 * 检测端口是否被占用
 */
fun isPortAvailable(port: Int) =
    try {
        portOccupationDetect("0.0.0.0", port)
        portOccupationDetect(InetAddress.getLocalHost().hostAddress, port)
        true
    } catch (e: Exception) {
        false
    }

/**
 * 捕获网络异常但不采取任何措施
 */
fun runWithNetworkCheck(block: () -> Unit) {
    try {
        block.invoke()
    } catch (_: SocketTimeoutException) {
    }
}