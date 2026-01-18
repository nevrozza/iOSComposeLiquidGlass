package org.nevrozq.iosliquid

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform