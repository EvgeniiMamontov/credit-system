package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.*;
import com.haulmont.creditsystem.service.ClientService;
import com.haulmont.creditsystem.service.LoanOfferService;
import com.haulmont.creditsystem.service.LoanService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/loanoffers")
public class LoanOfferController {

    private final ClientService clientService;
    private final LoanService loanService;
    private final LoanOfferService loanOfferService;

    public LoanOfferController(ClientService clientService, LoanService loanService, LoanOfferService loanOfferService) {
        this.clientService = clientService;
        this.loanService = loanService;
        this.loanOfferService = loanOfferService;
    }

    @GetMapping("/{loanOffer}")
    public String getLoanOffer(@PathVariable LoanOffer loanOffer, Model model) {
        model.addAttribute("loanoffer", loanOffer);
        return "loanoffers/loanoffer";
    }

    @GetMapping
    public String getAllLoanOffers(Model model) {
        model.addAttribute("loanoffers", loanOfferService.getAllLoanOffers() );
        return "loanoffers/loanoffers";
    }

    @GetMapping("/new")
    public String newLoanOffer(Model model) {
        model.addAttribute("loans", loanService.getAllLoans());
        model.addAttribute("clients", clientService.getAllClients());
        return "loanoffers/loanoffer_new";
    }

    @PostMapping("/new")
    public String addLoanOffer(@RequestParam(name = "client_uuid") Client client,
                          @RequestParam(name = "loan_uuid") Loan loan,
                          @RequestParam(name = "summ") long summ,
                          @RequestParam(name = "loan_term") int loanTerm,
                          @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstPaymentDate) {
        LoanOffer loanOffer = new LoanOffer(UUID.randomUUID(), client, loan, summ*100, loanTerm, firstPaymentDate);
        loanOfferService.generatePaymentSchedule(loanOffer);
        loan.getBank().addClient(client);
        UUID uuid = loanOfferService.save(loanOffer).getUuid();
        return "redirect:/loanoffers/" + uuid;
    }

    @GetMapping("/{loanOffer}/edit")
    public String editLoanOffer(Model model, @PathVariable LoanOffer loanOffer) {
        model.addAttribute("loanoffer", loanOffer);
        model.addAttribute("loans", loanService.getAllLoans());
        model.addAttribute("clients", clientService.getAllClients());
        return "loanoffers/loanoffer_edit";
    }

    @PostMapping("/{uuid}/edit")
    public String updateLoanOffer(@PathVariable UUID uuid,
                                  @RequestParam(name = "client_uuid") Client client,
                                  @RequestParam(name = "loan_uuid") Loan loan,
                                  @RequestParam(name = "summ") long summ,
                                  @RequestParam(name = "loan_term") int loanTerm,
                                  @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstPaymentDate) {
        LoanOffer loanOffer = loanOfferService.getByUuid(uuid);
        System.out.println(loanOffer);
        loanOffer.setClient(client);
        loanOffer.setLoan(loan);
        loanOffer.setAmount(summ*100);
        loanOffer.setLoanTerm(loanTerm);
        loanOffer.setDate(firstPaymentDate);
        //LoanOffer loanOffer = new LoanOffer(uuid, client, loan, summ*100, loanTerm, firstPaymentDate);
        loanOfferService.generatePaymentSchedule(loanOffer);
        loan.getBank().addClient(client);
        loanOfferService.save(loanOffer);
        return "redirect:/loanoffers/";
    }

    @GetMapping("/{loanOffer}/delete")
    public String deleteLoanOffer(@PathVariable LoanOffer loanOffer, Model model) {
        model.addAttribute("loanoffer", loanOffer);
        return "/loanoffers/loanoffer_delete";
    }

    @PostMapping("/{loanOffer}/delete")
    public String deleteLoanOffer(@PathVariable LoanOffer loanOffer) {
        loanOfferService.delete(loanOffer);
        return "redirect:/loanoffers/";
    }
}
