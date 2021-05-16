package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.Bank;
import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.service.BankService;
import com.haulmont.creditsystem.service.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final BankService bankService;

    public LoanController(LoanService loanService, BankService bankService) {
        this.loanService = loanService;
        this.bankService = bankService;
    }

    @GetMapping("/{loan}")
    public String getLoan(@PathVariable Loan loan, Model model) {
        model.addAttribute("loan", loan );
        return "loans/loan";
    }

    @GetMapping
    public String getAllLoans(Model model) {
        model.addAttribute("loans", loanService.getAllLoans() );
        return "loans/loans";
    }

    @GetMapping("/new")
    public String newLoan(Model model) {
        model.addAttribute("banks", bankService.getAllBanks());
        return "loans/loan_new";
    }

    @PostMapping("/new")
    public String addLoan(@RequestParam(name = "name") String name,
                          @RequestParam(name = "limit") long limit,
                          @RequestParam(name = "interest") float interest,
                          @RequestParam(name = "bank") Bank bank) {
        loanService.save(new Loan(name, limit*100, interest/100, bank));
        return "redirect:";
    }

    @GetMapping("/{loan}/edit")
    public String editLoan(@PathVariable Loan loan, Model model) {
        model.addAttribute("banks", bankService.getAllBanks());
        model.addAttribute("loan", loan);
        return "loans/loan_edit";
    }

    @PostMapping("/{uuid}/edit")
    public String updateLoan(@RequestParam(name = "uuid") Loan loan,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "limit") long limit,
                             @RequestParam(name = "interest") float interest,
                             @RequestParam(name = "bank") Bank bank) {
        loan.setName(name);
        loan.setLimit(limit * 100);
        loan.setInterestRate(interest / 100);
        loan.setBank(bank);
        loanService.save(loan);
        return "redirect:/loans/";
    }

    @GetMapping("/{loan}/delete")
    public String deleteLoan(@PathVariable Loan loan, Model model) {
        model.addAttribute("loan", loan);
        return "/loans/loan_delete";
    }

    @PostMapping("/{loan}/delete")
    public String deleteLoan(@PathVariable Loan loan) {
        loanService.delete(loan);
        return "redirect:/loans/";
    }
}
