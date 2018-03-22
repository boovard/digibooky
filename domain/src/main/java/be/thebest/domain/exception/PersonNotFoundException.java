package be.thebest.domain.exception;

public class PersonNotFoundException extends IllegalArgumentException {

    public PersonNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
