package dev.vishnu.productservice.exceptions;

import dev.vishnu.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleNotFoundException() {
//        return new ResponseEntity<ExceptionDto>(
//                new ExceptionDto(HttpStatus.NOT_FOUND, "Hi"),
//                HttpStatus.NOT_FOUND
//        );
//    }

    @ExceptionHandler(NotFoundException.class)
    private void handleNotFoundException() {
        System.out.println("Not Found");
    }
}
