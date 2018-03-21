package be.thebest.domain.exception;

public class IllegalFieldException extends IllegalArgumentException {

    public IllegalFieldException(String errorMessage) {
        super(errorMessage);
    }
}
