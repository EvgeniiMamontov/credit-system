package com.haulmont.creditsystem.service;

import com.haulmont.creditsystem.domain.LoanOffer;

import java.util.List;
import java.util.UUID;

public interface LoanOfferService {
    List<LoanOffer> getAllLoanOffers();
    LoanOffer save(LoanOffer loanOffer);
    LoanOffer getByUuid(UUID uuid);
    void delete(LoanOffer loanOffer);
    void generatePaymentSchedule(LoanOffer loanOffer);
}
