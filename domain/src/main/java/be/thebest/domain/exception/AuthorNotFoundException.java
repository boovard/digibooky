package be.thebest.domain.exception;

public class AuthorNotFoundException extends IllegalArgumentException {

    public AuthorNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
