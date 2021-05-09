package com.haulmont.creditsystem.service.impl;

import com.haulmont.creditsystem.domain.Client;
import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.repository.LoanRepository;
import com.haulmont.creditsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public Loan getByUuid(UUID uuid) {
        return loanRepository.findByUuid(uuid);
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        loanRepository.deleteByUuid(uuid);
    }
}
