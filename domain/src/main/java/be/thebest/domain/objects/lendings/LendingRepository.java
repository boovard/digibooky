package be.thebest.domain.objects.lendings;

import be.thebest.domain.objects.lendings.Lending;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class LendingRepository {
    private Map<Integer, Lending> lendingRepository;
    private Integer lendingCounter;

    public LendingRepository() {
        this.lendingRepository = new HashMap<>();
        this.lendingCounter = 0;
    }

    public Lending addLending(Lending lendingToAdd) {
        //TODO should not use 'contains' method
//        if (lendingRepository.keySet().size() > 0 && this.contains(lendingToAdd)) {
//            throw new IllegalArgumentException("That book is already lent out.");
//        }
        lendingRepository.put(lendingCounter++, lendingToAdd);
        return lendingRepository.get(lendingCounter - 1);
    }

    public boolean contains(Lending lendingToAdd) {
        return lendingRepository.values().stream()
                .anyMatch(lending -> lending.equals(lendingToAdd));
    }

    public void clear() {
        lendingRepository.clear();
    }
}
