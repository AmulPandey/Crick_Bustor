package org.assignment_life_easy.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform