package be.thebest.domain.exception;

public class AdressValidationException extends IllegalArgumentException {

    public AdressValidationException(String errorMessage) {
        super(errorMessage);
    }
}
