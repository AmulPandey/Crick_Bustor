package org.Crick_Bustor.project


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