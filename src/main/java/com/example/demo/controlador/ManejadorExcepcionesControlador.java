package com.example.demo.controlador;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class ManejadorExcepcionesControlador {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ProblemDetail> handleGeneralException(Exception exception) {
        log.error("internal_error: " + exception.getMessage());

        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        problemDetail.setTitle(exception.getClass().getCanonicalName());

        return ResponseEntity.internalServerError().body(problemDetail);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException(MethodArgumentTypeMismatchException exception) {
        log.error("parameter_error.%s: %s".formatted(exception.getName(), exception.getMostSpecificCause().getMessage()));

        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.PRECONDITION_FAILED, exception.getMostSpecificCause().getMessage());
        problemDetail.setTitle(exception.getParameter().getMethod().getName());
        problemDetail.setProperty(exception.getParameter().getParameterName(), exception.getValue());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problemDetail.setTitle("INPUT_NO_VALIDO");

        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName;
            try {
                fieldName = ((FieldError) error).getField();

            } catch (ClassCastException ex) {
                fieldName = error.getObjectName();
            }
            String message = error.getDefaultMessage();

            problemDetail.setProperty(fieldName, message);
        });

        return ResponseEntity.of(problemDetail).build();
    }
}
