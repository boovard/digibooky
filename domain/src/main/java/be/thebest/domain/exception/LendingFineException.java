package be.thebest.domain.exception;

public class LendingFineException extends RuntimeException {

    public LendingFineException(String errorMessage) {
        super(errorMessage);
    }

}
