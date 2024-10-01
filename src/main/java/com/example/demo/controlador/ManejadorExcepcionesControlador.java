package com.example.demo.controlador;

import com.example.demo.modelo.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ManejadorExcepcionesControlador {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void handleGeneralException(Exception exception) {
        log.error("internal_error: " + exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    void handleMethodArgumentNotValidException(MethodArgumentTypeMismatchException exception) {
        log.error("parameter_error.%s: %s".formatted(exception.getName(), exception.getMostSpecificCause().getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto[]> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ErrorDto> errors = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName;
            try {
                fieldName = ((FieldError) error).getField();

            } catch (ClassCastException ex) {
                fieldName = error.getObjectName();
            }
            String message = error.getDefaultMessage();

            errors.add(ErrorDto.builder().code("INPUT_NO_VALIDO").field(fieldName).message(message).build());
        });

        return new ResponseEntity<>(errors.toArray(ErrorDto[]::new), HttpStatus.BAD_REQUEST);
    }
}
