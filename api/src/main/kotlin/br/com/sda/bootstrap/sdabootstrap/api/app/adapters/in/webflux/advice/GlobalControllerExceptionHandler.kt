package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.advice

import br.com.sda.bootstrap.sdabootstrap.api.core.exception.EnrollmentNotElegibleException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerExceptionHandler {
    @ExceptionHandler(EnrollmentNotElegibleException::class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    fun handleEnrollmentNotElegibleException(ex: EnrollmentNotElegibleException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_ACCEPTABLE)
    }

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleBookNotFound(ex: RuntimeException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
