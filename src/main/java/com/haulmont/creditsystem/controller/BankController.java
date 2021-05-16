package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.Bank;
import com.haulmont.creditsystem.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{bank}")
    public String getBank(@PathVariable Bank bank, Model model) {
        model.addAttribute("bank", bank );
        return "banks/bank";
    }

    @GetMapping
    public String getAllBanks(Model model) {
        model.addAttribute("banks", bankService.getAllBanks() );
        return "banks/banks";
    }

    @GetMapping("/new")
    public String newBank() {
        return "banks/bank_new";
    }

    @PostMapping("/new")
    public String newBank(@RequestParam(name = "name") String name) {
        bankService.save(new Bank(name));
        return "redirect:";
    }

    @GetMapping("/{bank}/edit")
    public String editBank(@PathVariable Bank bank, Model model) {
        model.addAttribute("bank", bank);
        return "banks/bank_edit";
    }

    @PostMapping("/{uuid}/edit")
    public String editBank(@RequestParam(name = "uuid") Bank bank,
                           @RequestParam(name = "name") String name) {
        bank.setName(name);
        bankService.save(bank);
        return "redirect:/banks/";
    }

    @GetMapping("/{bank}/delete")
    public String deleteBank(@PathVariable Bank bank, Model model) {
        model.addAttribute("bank", bank);
        return "/banks/bank_delete";
    }

    @PostMapping("/{bank}/delete")
    public String deleteBank(@PathVariable Bank bank) {
        bankService.delete(bank);
        return "redirect:/banks/";
    }
}
