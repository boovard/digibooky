package be.thebest.domain.exception;

public class NotFoundException extends IllegalArgumentException {

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
