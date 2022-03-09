package com.volvocars.mediasample.common.logging

object LoggerFactory {
    fun create(): Logger = TestLogger()
}

private class TestLogger : Logger {
    override fun debug(tag: String, message: String) {
        println("Tag: $tag | message: $message")
    }

    override fun info(tag: String, message: String) {
        println("Tag: $tag | message: $message")
    }

    override fun warning(tag: String, message: String) {
        println("Tag: $tag | message: $message")
    }

    override fun error(tag: String, message: String) {
        println("Tag: $tag | message: $message")
    }

    override fun error(tag: String, message: String?, throwable: Throwable) {
        print("$tag|")
        message?.let {
            print(it)
            println()
        }
        print(throwable)
    }
}
