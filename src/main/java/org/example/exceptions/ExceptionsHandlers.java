package org.example.exceptions;

import org.example.api.model.response.ErrorResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionsHandlers {

    private static ResponseEntity<Object> makeResponse(HttpStatus httpStatus, Exception exception) {
        return ResponseEntity.status(httpStatus).body(ErrorResponseBody.from(exception, httpStatus));
    }

    @ExceptionHandler(CreateIdeaException.class)
    public ResponseEntity<Object> handleInvalidUserIdException(CreateIdeaException exception, WebRequest request) {
        return makeResponse(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> defaultExceptionHandler(Exception exception, WebRequest request) {
        return makeResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

}
