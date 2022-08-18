package com.wa_project.controller_advice


import com.wa_project.controller_advice.exceptions.BadGatewayException
import com.wa_project.controller_advice.exceptions.NotFoundException
import com.wa_project.controller_advice.exceptions.PreconditionFailedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.Clock

@RestControllerAdvice
class RestResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(PreconditionFailedException::class)
    fun handlePreconditionFailedException(ex: PreconditionFailedException): ResponseEntity<Any> {
        val errors = createResponse(
            HttpStatus.PRECONDITION_FAILED.value(),
            "Precondition Failed",
            ex.message        )
        return ResponseEntity(errors, HttpStatus.PRECONDITION_FAILED)
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(BadGatewayException::class)
    fun handleBadGatewayException(ex: BadGatewayException): ResponseEntity<Any> {
        val errors = createResponse(
            HttpStatus.BAD_GATEWAY.value(),
            "Bad Gateway",
            ex.message        )
        return ResponseEntity(errors, HttpStatus.BAD_GATEWAY)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<Any> {
        val errors = createResponse(HttpStatus.NOT_FOUND.value(), "NOT FOUND", ex.message)
        return ResponseEntity(errors, HttpStatus.NOT_FOUND)
    }

    fun createResponse(status: Int, error: String?, message: String?): kotlin.collections.Map<String, String?> {
        val errors: MutableMap<String, String?> = HashMap()
        errors["timestamp"] = Clock.systemUTC().instant().toString()
        errors["status"] = status.toString()
        errors["error"] = error
        errors["message"] = message
        return errors
    }
}