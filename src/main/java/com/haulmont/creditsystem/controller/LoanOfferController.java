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
import java.util.List;
import java.util.UUID;

@Controller
public class LoanOfferController {

    private ClientService clientService;
    private LoanService loanService;
    private LoanOfferService loanOfferService;

    public LoanOfferController(ClientService clientService, LoanService loanService, LoanOfferService loanOfferService) {
        this.clientService = clientService;
        this.loanService = loanService;
        this.loanOfferService = loanOfferService;
    }

    @GetMapping("loanoffers")
    public String getAllLoanOffers(Model model) {
        model.addAttribute("loanoffers", loanOfferService.getAllLoanOffers() );
        return "loanoffers/loanoffers";
    }

    @GetMapping("client/{uuid}/newoffer")
    public String newLoanOffer(Model model, @PathVariable(name = "uuid") UUID uuid) {
        model.addAttribute("client", clientService.getByUuid(uuid));
        model.addAttribute("loans", loanService.getAllLoans());
        model.addAttribute("clients", clientService.getAllClients());
        return "loanoffers/loanoffer_new";
    }

    @PostMapping("client/{uuid}/newoffer")
    public String addLoanOffer(@RequestParam(name = "client_uuid") UUID clientUuid,
                          @RequestParam(name = "loan_uuid") UUID loanUuid,
                          @RequestParam(name = "summ") long summ,
                          @RequestParam(name = "loan_term") int loanTerm,
                          @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstPaymentDate) {
        Client client = clientService.getByUuid(clientUuid);
        Loan loan = loanService.getByUuid(loanUuid);
        LoanOffer loanOffer = new LoanOffer(client, loan, summ * 100, loanTerm, firstPaymentDate);
        List<Payment> paymentSchedule = loanOfferService.generatePaymentSchedule(loan, summ * 100, loanTerm, firstPaymentDate, loanOffer);
        loanOffer.setPaymentSchedule(paymentSchedule);
        UUID uuid = loanOfferService.save(loanOffer).getUuid();
        return "redirect:/loanoffers/" + uuid;
    }

    @GetMapping("loanoffers/{loanOffer}/edit")
    public String editLoanOffer(Model model, @PathVariable LoanOffer loanOffer) {
        model.addAttribute("loanoffer", loanOffer);
        model.addAttribute("currentClient", loanOffer.getClient());
        model.addAttribute("loans", loanService.getAllLoans());
        model.addAttribute("clients", clientService.getAllClients());
        return "loanoffers/loanoffer_edit";
    }

    @PostMapping("loanoffers/{uuid}/edit")
    public String updateLoanOffer(@PathVariable UUID uuid,
                                  @RequestParam(name = "client_uuid") UUID clientUuid,
                                  @RequestParam(name = "loan_uuid") UUID loanUuid,
                                  @RequestParam(name = "summ") long summ,
                                  @RequestParam(name = "loan_term") int loanTerm,
                                  @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstPaymentDate) {
        Client client = clientService.getByUuid(clientUuid);
        Loan loan = loanService.getByUuid(loanUuid);
        LoanOffer loanOffer = new LoanOffer(uuid, client, loan, summ * 100, loanTerm, firstPaymentDate);
        List<Payment> paymentSchedule = loanOfferService.generatePaymentSchedule(loan, summ * 100, loanTerm, firstPaymentDate, loanOffer);
        loanOffer.setPaymentSchedule(paymentSchedule);
        loanOfferService.save(loanOffer);
        return "redirect:/loanoffers/";
    }

    @GetMapping("loanoffers/{loanOffer}")
    public String getLoanOffer(@PathVariable LoanOffer loanOffer, Model model) {
        model.addAttribute("loanoffer", loanOffer);
        return "loanoffers/loanoffer";
    }

    @GetMapping("loanoffers/{loanOffer}/delete")
    public String deleteLoanOffer(@PathVariable LoanOffer loanOffer, Model model) {
        model.addAttribute("loanoffer", loanOffer);
        return "/loanoffers/loanoffer_delete";
    }

    @PostMapping("loanoffers/{loanOffer}/delete")
    public String deleteLoanOffer(@PathVariable LoanOffer loanOffer) {
        loanOfferService.delete(loanOffer);
        return "redirect:/loanoffers/";
    }
}
