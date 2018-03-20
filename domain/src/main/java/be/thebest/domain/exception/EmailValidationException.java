package be.thebest.domain.exception;

public class EmailValidationException extends IllegalArgumentException{

    public EmailValidationException(String errorMessage) {
        super(errorMessage);
    }
}
