package com.ogrvassiem.partygames.aplication.utils.rest

sealed class TechnicalError {

    data class ExceptionError(
        val exception: Exception
    ) : TechnicalError()

    data class HttpError(
        val statusCode: Int,
        val message: String,
        val showToUser: Boolean = false,
    ) : TechnicalError()

    data class NetworkError(
        val exception: Exception
    ) : TechnicalError()
}