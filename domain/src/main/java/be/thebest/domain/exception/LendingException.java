package be.thebest.domain.exception;

public class LendingException extends RuntimeException {

    public LendingException(String errorMessage) {
        super(errorMessage);
    }
}
