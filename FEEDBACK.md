# Feedback

# Functional packaging
- Create functional packages. Functional packages better follow how we reason as a developer. 
E.g.: "I need to make some changes in the domain related to books.":
    ```
    | --- books
      | --- BookDto
      | --- BookMapper
      | --- BookController
    | --- members
    | --- lendings
    ```
    - Try to avoid technical packages like these (see your `domain` and `service` modules):
        ```
        | --- exception
        | --- objects
        | --- repositories
        ```
    - Could be refactored to functional packages:
        ```
        | --- books
          | --- Book
          | --- BookRepository
          | --- ...
        | --- objects
        | --- repositories
        ```
- Keep your code organized! A lot of the files in `api` are package-less (LendingDto, PersonDto,...). Organize them.

# Author ID
- From the front-end, I can provide a ID in the `AuthorDto` which will simply be mapped to the `Author`. In other words,
it's up to the front-end to create and id of the `Author` (should never be the case!). 
I can even update the id of an existing `Author` (should never be the case!).
```
// In AuthorDto
public Author toDomain(AuthorDto authorDto){
    return new Author(authorDto.getAuthorId(), authorDto.getLastName(), authorDto.getFirstName());
}
```
- This is a recurring problem. You have the same issue with the ID's of Lending, Member,...

# Unused dependencies
- E.g. `LendingService` injects the `BookRepository`, but never uses it...
    - Maybe it was used before, but not any longer: then make sure to clean up your code!
    - If you might use it in the future, then only add it the moment you need it (YAGNI: You Ain't Gonna Need It)
    
# Readability
- In general: small methods, readable methods / code. Good job!