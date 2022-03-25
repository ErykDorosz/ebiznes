package com.ebiznes.elektronik.controller.advice;

import com.ebiznes.elektronik.dto.ErrorResponse;
import com.ebiznes.elektronik.exception.UserExistsException;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { UserExistsException.class })
    public ResponseEntity<ErrorResponse> userExists(UserExistsException ex, WebRequest request) {
        val error = ErrorResponse.builder()
                .message("User exists")
                .code(400)
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
