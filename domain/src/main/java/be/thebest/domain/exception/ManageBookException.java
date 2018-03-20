package be.thebest.domain.exception;

public class ManageBookException extends RuntimeException {

    public ManageBookException(String errorMessage) {
        super(errorMessage);
    }
}
