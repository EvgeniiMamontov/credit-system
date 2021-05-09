package com.haulmont.creditsystem.repository;

import com.haulmont.creditsystem.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
}