package com.trepudox.animal.core.exception.handler;

import com.trepudox.animal.core.exception.EntityNotFoundException;
import com.trepudox.animal.core.exception.handler.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleEntityNotFoundException(EntityNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

        ErrorMessageDTO errorMessageDTO = createErrorMessageDTO("Entidade não encontrada", e.getMessage(), httpStatus.value());

        return new ResponseEntity<>(errorMessageDTO, httpStatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessageDTO> handleIllegalArgumentException(Exception e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ErrorMessageDTO errorMessageDTO = createErrorMessageDTO("A requisição não pôde ser processada", e.getMessage(), httpStatus.value());

        return new ResponseEntity<>(errorMessageDTO, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDTO> handleGenericExceptions(Exception e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorMessageDTO errorMessageDTO = createErrorMessageDTO("Um erro inesperado ocorreu", e.getMessage(), httpStatus.value());

        return new ResponseEntity<>(errorMessageDTO, httpStatus);
    }

    private ErrorMessageDTO createErrorMessageDTO(String description, String message, int status) {
        return ErrorMessageDTO.builder()
                .description(description)
                .errorMessage(message)
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
