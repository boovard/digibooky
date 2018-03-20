package be.thebest.domain.objects;

public class Author {

    private int authorId;
    private String lastName;
    private String firstName;

    public Author(int authorId, String lastName, String firstName) {
        this.authorId = authorId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAuthorId() {
        return authorId;
    }
}
