package be.thebest.api.authors;

public class AuthorDto {
    private int authorId;
    private String lastName;
    private String firstName;


    public static AuthorDto authorDto(){
        return new AuthorDto();
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public int getAuthorId() {
        return authorId;
    }

    public AuthorDto withAuthorId(int authorId){
        this.authorId = authorId;
        return this;
    }
}
