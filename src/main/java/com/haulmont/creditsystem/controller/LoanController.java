package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("")
    public String getAllLoans(Model model) {
        model.addAttribute("loans", loanService.getAllLoans() );
        return "loan";
    }

    @GetMapping("/new")
    public String newLoan() {
        return "loan_new";
    }

    @PostMapping("/new")
    public String addLoan(@RequestParam(name = "name") String name,
                          @RequestParam(name = "limit") long limit,
                          @RequestParam(name = "interest") int interest) {
        loanService.save(new Loan(name, limit, interest));
        return "redirect:";
    }

    @GetMapping("/{uuid}/edit")
    public String editLoan(@PathVariable UUID uuid, Model model) {
        model.addAttribute("loan", loanService.getByUuid(uuid));
        return "loan_edit";
    }

    @PostMapping("/{uuid}/edit")
    public String updateLoan(@PathVariable(name = "uuid") UUID uuid,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "limit") long limit,
                             @RequestParam(name = "interest") int interest) {
        loanService.save(new Loan(uuid, name, limit, interest));
        return "redirect:/loans/";
    }

    @GetMapping("/{uuid}/delete")
    public String deleteLoan(@PathVariable UUID uuid) {
        loanService.delete(uuid);
        return "redirect:/loans/";
    }

}
