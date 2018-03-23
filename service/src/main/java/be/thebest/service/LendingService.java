package be.thebest.service;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.exception.NotFoundException;
import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.objects.lendings.LendingRepository;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.repositories.BookRepository;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Map;

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

    public ReturnObject returnBook(Long lendingId) {
        if (!lendingRepository.getLendingRepository().keySet().contains(lendingId)) {
            return ReturnObject.returnObject(ReturnObject.ERROR,
                    "Lending not found. The book may already have been returned, or you provided a wrong lending ID.");
        }
        if (lendingRepository.getLending(lendingId).getDueDate(Lending.NORMAL_LENDING_PERIOD).isBefore(LocalDate.now())) {
            return ReturnObject.returnObject(ReturnObject.OK_WITH_MESSAGE,
                    "Book is overdue. You should have returned it by " + lendingRepository.getLending(lendingId).getDueDate(Lending.NORMAL_LENDING_PERIOD));
        }
        lendingRepository.removeLending(lendingId);
        return ReturnObject.returnObject(ReturnObject.OK);
    }

    public Map<Book, LocalDate> getLentBooksByMember(Member member) {
        return lendingRepository.getLentBooksByMember(member);

    }
}
