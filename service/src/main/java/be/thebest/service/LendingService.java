package be.thebest.service;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.objects.lendings.LendingRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LendingService {
    private LendingRepository lendingRepository;

    @Inject
    public LendingService(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    public Lending addLending(Lending lendingToAdd) {
        if (lendingRepository.getLendingRepositorySize() > 0 && lendingRepository.containsBook(lendingToAdd.getBook())) {
            throw new LendingException("That book is already lent out.");
        }
        return lendingRepository.addLending(lendingToAdd);
    }
}
