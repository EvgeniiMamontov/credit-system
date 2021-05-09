package com.haulmont.creditsystem.service;

import com.haulmont.creditsystem.domain.Loan;

import java.util.List;
import java.util.UUID;

public interface LoanService {
    List<Loan> getAllLoans();
    void save(Loan loan);
    Loan getByUuid(UUID uuid);
    void delete(UUID uuid);
}
