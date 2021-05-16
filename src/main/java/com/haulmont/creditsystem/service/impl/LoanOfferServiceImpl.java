package com.haulmont.creditsystem.service.impl;

import com.haulmont.creditsystem.domain.LoanOffer;
import com.haulmont.creditsystem.domain.Payment;
import com.haulmont.creditsystem.repository.LoanOfferRepository;
import com.haulmont.creditsystem.service.LoanOfferService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

    private final LoanOfferRepository loanOfferRepository;

    public LoanOfferServiceImpl(LoanOfferRepository loanOfferRepository) {
        this.loanOfferRepository = loanOfferRepository;
    }

    @Override
    public List<LoanOffer> getAllLoanOffers() {
        return loanOfferRepository.findAll();
    }

    @Override
    @Transactional
    public LoanOffer save(LoanOffer loanOffer) {
        return loanOfferRepository.save(loanOffer);
    }

    @Override
    public LoanOffer getByUuid(UUID uuid) {
        return loanOfferRepository.findByUuid(uuid);
    }

    @Override
    @Transactional
    public void delete(LoanOffer loanOffer) {
        loanOfferRepository.delete(loanOffer);
    }

    @Override
    public void generatePaymentSchedule(LoanOffer loanOffer) {
        float p = loanOffer.getLoan().getInterestRate() / 12; // percentage of interest rate (month)
        long monthlyPayment = (long) Math.round(loanOffer.getAmount() * (p + (p / (Math.pow((1 + p), loanOffer.getLoanTerm()) - 1))));

        long interestTotal = 0;
        long summ = loanOffer.getAmount();
        List<Payment> paymentSchedule = loanOffer.getPaymentSchedule();
        paymentSchedule.clear();
        for (int i = 0; i < loanOffer.getLoanTerm(); i++) {
            long interestAmount = (long) Math.floor(summ * p);
            long principalAmount = monthlyPayment - interestAmount;
            summ -= principalAmount;
            paymentSchedule.add(new Payment(UUID.randomUUID(), loanOffer.getDate().plusMonths(i), monthlyPayment, principalAmount, interestAmount, loanOffer));
            interestTotal += interestAmount;
        }
        loanOffer.setInterestTotal(interestTotal);
        loanOffer.setPaymentSchedule(paymentSchedule);
    }
}
