package be.thebest.domain.exception;

public class ManagementException extends RuntimeException {

    public ManagementException(String errorMessage) {
        super(errorMessage);
    }
}
