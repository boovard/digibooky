package be.thebest.domain.exception;

public class IsbnValidationException extends IllegalArgumentException {

    public IsbnValidationException(String errorMessage) {
        super(errorMessage);
    }
}
