package be.thebest.api;

import be.thebest.domain.exception.ManagementException;
import be.thebest.domain.exception.NotFoundException;
import be.thebest.domain.exception.IllegalFieldException;
import be.thebest.domain.exception.LendingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "be.thebest")
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> convertBookNotFoundException(final NotFoundException exception){
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalFieldException.class)
    public  ResponseEntity<String> convertIllegalFieldException(final IllegalFieldException exception){
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LendingException.class)
    public ResponseEntity<String>  convertLendingException(final LendingException exception){
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ManagementException.class)
    public ResponseEntity<String> convertManagementException(final ManagementException exception){
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_ACCEPTABLE);
    }

}
