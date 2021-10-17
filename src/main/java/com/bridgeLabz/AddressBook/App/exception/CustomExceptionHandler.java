package com.bridgeLabz.AddressBook.App.exception;

import com.bridgeLabz.AddressBook.App.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Address Book exception handler handles exception and shows HTTP Bad Requests or display if Internal servererror occurs.
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 15-10-2021
 */

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> globalExceptionHandler(Exception ex) {
        return new ResponseEntity<>(new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> customExceptionHandler(Exception ex) {
        return new ResponseEntity<>(new ResponseDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null),
                HttpStatus.BAD_REQUEST);
    }

}
