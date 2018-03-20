package be.thebest.domain.exception;

public class BookNotFoundException extends IllegalArgumentException {

    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
