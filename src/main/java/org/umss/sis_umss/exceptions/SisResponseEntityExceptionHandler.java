package org.umss.sis_umss.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // Call me before each controller
@RestController
public class SisResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        SisExceptionResponse sisExceptionResponse = new SisExceptionResponse(new Date(), "InternalServerError", request.getDescription(false));
        return  new ResponseEntity<>(sisExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request)  {
        SisExceptionResponse sisExceptionResponse = new SisExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return  new ResponseEntity<>(sisExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
