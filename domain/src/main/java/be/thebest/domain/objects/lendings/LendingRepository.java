package be.thebest.domain.objects.lendings;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.repositories.BookRepository;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<Book, LocalDate> getLentBooksByMember(Member member) {
        Map<Long, Lending> filteredLendings = lendingRepository.entrySet().stream()
                .filter(entry -> entry.getValue().getMember().equals(member))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return filteredLendings.values().stream()
                .collect(Collectors.toMap(Lending::getBook, lending -> lending.getDueDate(Lending.NORMAL_LENDING_PERIOD)));
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
