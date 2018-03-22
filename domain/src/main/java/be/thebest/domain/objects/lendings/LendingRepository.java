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
        return null;
    }

    public boolean contains(Lending lending) {
        return true;
    }
}
