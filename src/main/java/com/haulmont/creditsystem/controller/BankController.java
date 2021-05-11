package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.Bank;
import com.haulmont.creditsystem.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

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
    public String addBank(@RequestParam(name = "name") String name) {
        bankService.save(new Bank(name));
        return "redirect:";
    }

    @GetMapping("/{uuid}/edit")
    public String editBank(@PathVariable UUID uuid, Model model) {
        model.addAttribute("bank", bankService.getByUuid(uuid));
        return "banks/bank_edit";
    }

    @PostMapping("/{uuid}/edit")
    public String updateBank(@PathVariable(name = "uuid") UUID uuid,
                             @RequestParam(name = "name") String name) {
        bankService.save(new Bank(uuid, name, null, null));
        return "redirect:/banks/";
    }

    @GetMapping("/{uuid}/delete")
    public String deleteBank(@PathVariable UUID uuid) {
        bankService.delete(uuid);
        return "redirect:/banks/";
    }

    @GetMapping("/{uuid}")
    public String getBank(@PathVariable UUID uuid, Model model) {
        model.addAttribute("bank", bankService.getByUuid(uuid) );
        return "banks/bank";
    }
}
