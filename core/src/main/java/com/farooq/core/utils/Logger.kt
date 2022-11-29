package com.farooq.core.utils

import timber.log.Timber


class Logger(private val tag: String, private val isDebug: Boolean) {

    fun log(msg: String) {
        if (!isDebug) {
            // Production firebase crashlytics implementation
        } else {
            printLogD(tag, msg)
        }
    }

    companion object Factory {

        fun buildDebug(tag: String): Logger {
            return Logger(tag = tag, isDebug = true)
        }

        fun buildRelease(tag: String): Logger {
            return Logger(tag = tag, isDebug = false)
        }
    }
}

fun printLogD(tag: String, message: String) {
    Timber.tag(tag).d(message)
}