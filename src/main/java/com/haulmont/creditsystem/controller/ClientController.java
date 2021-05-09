package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.Client;
import com.haulmont.creditsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients() );
        return "client";
    }

    @GetMapping("/new")
    public String newClient() {
        return "client_new";
    }

    @PostMapping("/new")
    public String addClient(@RequestParam(name = "name") String fullName,
                            @RequestParam(name = "phone") String phoneNumber,
                            @RequestParam(name = "email") String email,
                            @RequestParam(name = "passport") String passportNumber) {
        clientService.save(new Client(fullName, phoneNumber, email, passportNumber));
        return "redirect:";
    }

    @GetMapping("/{uuid}/edit")
    public String editClient(@PathVariable UUID uuid, Model model) {
        model.addAttribute("client", clientService.getByUuid(uuid));
        return "client_edit";
    }

    @PostMapping("/{uuid}/edit")
    public String updateClient(@PathVariable(name = "uuid") UUID uuid,
                               @RequestParam(name = "name") String fullName,
                               @RequestParam(name = "phone") String phoneNumber,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "passport") String passportNumber) {
        clientService.save(new Client(uuid, fullName, phoneNumber, email, passportNumber));
        return "redirect:/clients/";
    }

    @GetMapping("/{uuid}/delete")
    public String deleteClient(@PathVariable UUID uuid) {
        clientService.delete(uuid);
        return "redirect:/clients/";
    }
}
