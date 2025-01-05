package org.assignment_life_easy.project

enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    UNAUTHORIZED,
    FORBIDDEN,
    CONFLICT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    PAYLOAD_TOO_LARGE,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN;
}