package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.Client;
import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.domain.LoanOffer;
import com.haulmont.creditsystem.service.ClientService;
import com.haulmont.creditsystem.service.LoanOfferService;
import com.haulmont.creditsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class LoanOfferController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanOfferService loanOfferService;

    @GetMapping("loanoffers")
    public String getAllLoanOffers(Model model) {
        model.addAttribute("loanoffers", loanOfferService.getAllLoanOffers() );
        return "loanoffers/loanoffers";
    }

    @GetMapping("client/{uuid}/newoffer")
    public String newLoanOffer(Model model, @PathVariable(name = "uuid") UUID uuid) {
        model.addAttribute("client", clientService.getByUuid(uuid));
        model.addAttribute("loans", loanService.getAllLoans());
        return "loanoffers/loanoffer_new";
    }

    @PostMapping("client/{uuid}/newoffer")
    public String addLoanOffer(@RequestParam(name = "client_uuid") UUID clientUuid,
                          @RequestParam(name = "loans_uuid") UUID loanUuid,
                          @RequestParam(name = "summ") long summ,
                          @RequestParam(name = "loan_term") int loanTerm,
                          @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstPaymentDate) {
        Client client = clientService.getByUuid(clientUuid);
        Loan loan = loanService.getByUuid(loanUuid);
        loanOfferService.save(new LoanOffer(client, loan, summ, loanTerm, firstPaymentDate));
        return "redirect:/loanoffers";
    }

    @GetMapping("loanoffers/{uuid}/edit")
    public String editLoanOffer(Model model, @PathVariable(name = "uuid") UUID uuid) {
        LoanOffer loanOffer = loanOfferService.getByUuid(uuid);
        model.addAttribute("loanoffer", loanOffer);
        model.addAttribute("client", loanOffer.getClient());
        model.addAttribute("loans", loanService.getAllLoans());
        return "loanoffers/loanoffer_edit";
    }

    @PostMapping("loanoffers/{uuid}/edit")
    public String updateLoanOffer(@PathVariable(name = "uuid") UUID uuid,
                                  @RequestParam(name = "client_uuid") UUID clientUuid,
                                  @RequestParam(name = "loans_uuid") UUID loanUuid,
                                  @RequestParam(name = "summ") long summ,
                                  @RequestParam(name = "loan_term") int loanTerm,
                                  @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstPaymentDate) {
        Client client = clientService.getByUuid(clientUuid);
        Loan loan = loanService.getByUuid(loanUuid);
        loanOfferService.save(new LoanOffer(uuid, client, loan, summ, loanTerm, firstPaymentDate));
        return "redirect:/loanoffers/";
    }

    @GetMapping("loanoffers/{uuid}/delete")
    public String deleteLoanOffer(@PathVariable UUID uuid) {
        loanOfferService.delete(uuid);
        return "redirect:/loanoffers/";
    }

    @GetMapping("loanoffers/{uuid}")
    public String getLoanOffer(@PathVariable UUID uuid, Model model) {
        model.addAttribute("loanoffer", loanOfferService.getByUuid(uuid) );
        return "loanoffers/loanoffer";
    }
}
