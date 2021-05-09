package com.haulmont.creditsystem.service.impl;

import com.haulmont.creditsystem.domain.Bank;
import com.haulmont.creditsystem.repository.BankRepository;
import com.haulmont.creditsystem.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public Bank getByUuid(UUID uuid) {
        return bankRepository.findByUuid(uuid);
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        bankRepository.deleteByUuid(uuid);
    }
}
