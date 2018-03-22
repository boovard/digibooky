package be.thebest.domain.objects.lendings;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.repositories.BookRepository;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Named
public class LendingRepository {
    private Map<Long, Lending> lendingRepository;
    private Long lendingCounter;

    public LendingRepository() {
        this.lendingRepository = new HashMap<>();
        this.lendingCounter = 0L;
    }

    public Lending addLending(Lending lendingToAdd) {
        lendingToAdd.setLendingId(lendingCounter);
        lendingRepository.put(lendingCounter++, lendingToAdd);
        return lendingRepository.get(lendingCounter - 1);
    }

    public boolean containsLending(Lending lendingToAdd) {
        return lendingRepository.values().stream()
                .anyMatch(lending -> lending.equals(lendingToAdd));
    }

    public boolean containsBook(Book bookToLend) {
        return lendingRepository.values().stream()
                .anyMatch(lending -> lending.getBook().equals(bookToLend));
    }

    public void removeLending(Long lendingId) {
        lendingRepository.remove(lendingId);
    }

    public Lending getLending(Long lendingId) {
        return lendingRepository.get(lendingId);
    }

    public void clear() {
        lendingRepository.clear();
    }

    public int getLendingRepositorySize() {
        return lendingRepository.size();
    }

    public Map<Long, Lending> getLendingRepository() {
        return Collections.unmodifiableMap(lendingRepository);
    }

    public Long getLendingCounter() {
        return lendingCounter;
    }
}
