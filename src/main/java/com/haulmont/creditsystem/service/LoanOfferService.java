package com.haulmont.creditsystem.service;

import com.haulmont.creditsystem.domain.LoanOffer;

import java.util.List;
import java.util.UUID;

public interface LoanOfferService {
    List<LoanOffer> getAllLoanOffers();
    void save(LoanOffer loanOffer);
    LoanOffer getByUuid(UUID uuid);
    void delete(UUID uuid);
}
