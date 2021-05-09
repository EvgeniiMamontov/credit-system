package com.haulmont.creditsystem.service;

import com.haulmont.creditsystem.domain.Bank;

import java.util.List;
import java.util.UUID;

public interface BankService {
    List<Bank> getAllBanks();
    void save(Bank bank);
    Bank getByUuid(UUID uuid);
    void delete(UUID uuid);
}

