package org.example.api.model.response;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Optional;

public record ErrorResponseBody(
        int status,
        String statusCodeReasonPhrase,
        String exceptionClass,
        String exceptionMessage,
        Date date
) {

    public static ErrorResponseBody from(Exception exception, HttpStatus httpStatus) {
        return new ErrorResponseBody(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                exception.getClass().getSimpleName(),
                Optional.ofNullable(exception.getMessage()).orElse(""),
                new Date()
        );
    }

}
