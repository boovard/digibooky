package be.thebest.domain.exception;

public class LendingBookException extends RuntimeException {

    public LendingBookException(String errorMessage) {
        super(errorMessage);
    }
}
