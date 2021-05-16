package com.haulmont.creditsystem.service.impl;

import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.repository.LoanRepository;
import com.haulmont.creditsystem.service.LoanService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    @Transactional
    public Loan save(Loan loan) {
       return loanRepository.save(loan);
    }

    @Override
    public Loan getByUuid(UUID uuid) {
        return loanRepository.findByUuid(uuid);
    }

    @Override
    @Transactional
    public void delete(Loan loan) {
        System.out.println(loan);
        loanRepository.delete(loan);
    }
}
