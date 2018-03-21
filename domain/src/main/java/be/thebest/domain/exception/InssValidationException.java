package be.thebest.domain.exception;

public class InssValidationException extends IllegalArgumentException {

    public InssValidationException(String errorMessage) {
        super(errorMessage);
    }
}
