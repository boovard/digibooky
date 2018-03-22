package be.thebest.service;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.objects.lendings.LendingRepository;
import be.thebest.domain.repositories.BookRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LendingService {
    private LendingRepository lendingRepository;
    private BookRepository bookRepository;

    @Inject
    public LendingService(LendingRepository lendingRepository, BookRepository bookRepository) {
        this.lendingRepository = lendingRepository;
        this.bookRepository = bookRepository;
    }

    public Lending addLending(Lending lendingToAdd) {
        if (lendingRepository.getLendingRepositorySize() > 0 && lendingRepository.containsBook(lendingToAdd.getBook())) {
            throw new LendingException("That book is already lent out.");
        }
        return lendingRepository.addLending(lendingToAdd);
    }
}
