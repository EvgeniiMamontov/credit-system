package com.haulmont.creditsystem.service.impl;

import com.haulmont.creditsystem.domain.LoanOffer;
import com.haulmont.creditsystem.repository.LoanOfferRepository;
import com.haulmont.creditsystem.service.LoanOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

    @Autowired
    private LoanOfferRepository loanOfferRepository;

    @Override
    public List<LoanOffer> getAllLoanOffers() {
        return loanOfferRepository.findAll();
    }

    @Override
    @Transactional
    public void save(LoanOffer loanOffer) {
        loanOfferRepository.save(loanOffer);
    }

    @Override
    public LoanOffer getByUuid(UUID uuid) {
        return loanOfferRepository.findByUuid(uuid);
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        loanOfferRepository.deleteByUuid(uuid);
    }
}
