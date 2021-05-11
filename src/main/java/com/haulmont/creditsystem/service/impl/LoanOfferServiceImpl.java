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

    @Override
    public List<Payment> generatePaymentSchedule(Loan loan, long summ, int loanTerm, LocalDate firstPaymentDate) {
        List<Payment> result = new ArrayList<>();
        double interest = loan.getInterestRate();
        double p = interest/12/100; // percentage of interest rate (month)
        long monthlyPayment = (long) Math.floor(summ * (p + (p / (Math.pow((1 + p), loanTerm) - 1))));

        for (int i = 0; i < loanTerm; i++) {
            LocalDate date = firstPaymentDate.plusMonths(i);
            long interestAmount = (long) Math.floor(summ * p);
            long principalAmount = monthlyPayment - interestAmount;
            long balanceOwed = summ - principalAmount;
            result.add(new Payment(date, monthlyPayment, principalAmount, interestAmount));
            summ = balanceOwed;
        }
        return result;
    }
}
