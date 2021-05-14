package com.haulmont.creditsystem.service;

import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.domain.LoanOffer;
import com.haulmont.creditsystem.domain.Payment;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LoanOfferService {
    List<LoanOffer> getAllLoanOffers();
    LoanOffer save(LoanOffer loanOffer);
    LoanOffer getByUuid(UUID uuid);
    void delete(LoanOffer loanOffer);
    List<Payment> generatePaymentSchedule(Loan loan, long summ, int loanTerm, LocalDate firstPaymentDate, LoanOffer loanOffer);
}
