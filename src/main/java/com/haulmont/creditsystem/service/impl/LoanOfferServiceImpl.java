package com.haulmont.creditsystem.service.impl;

import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.domain.LoanOffer;
import com.haulmont.creditsystem.domain.Payment;
import com.haulmont.creditsystem.repository.LoanOfferRepository;
import com.haulmont.creditsystem.service.LoanOfferService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

    private LoanOfferRepository loanOfferRepository;

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
    public List<Payment> generatePaymentSchedule(Loan loan, long summ, int loanTerm, LocalDate firstPaymentDate, LoanOffer loanOffer) {
        List<Payment> result = new ArrayList<>();
        float interest = loan.getInterestRate();
        float p = interest / 12; // percentage of interest rate (month)
        long monthlyPayment = (long) Math.floor(summ * (p + (p / (Math.pow((1 + p), loanTerm) - 1))));
        long interestTotal = 0;

        for (int i = 0; i < loanTerm; i++) {
            LocalDate date = firstPaymentDate.plusMonths(i);
            long interestAmount = (long) Math.floor(summ * p);
            interestTotal += interestAmount;
            long principalAmount = monthlyPayment - interestAmount;
            long balanceOwed = summ - principalAmount;
            result.add(new Payment(date, monthlyPayment, principalAmount, interestAmount, loanOffer));
            summ = balanceOwed;
        }
        loanOffer.setInterestTotal(interestTotal);
        return result;
    }
}
