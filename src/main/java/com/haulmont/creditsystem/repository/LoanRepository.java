package com.haulmont.creditsystem.repository;

import com.haulmont.creditsystem.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
}
