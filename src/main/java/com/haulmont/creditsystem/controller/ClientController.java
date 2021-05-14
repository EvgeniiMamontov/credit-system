package com.haulmont.creditsystem.controller;

import com.haulmont.creditsystem.domain.Bank;
import com.haulmont.creditsystem.domain.Client;
import com.haulmont.creditsystem.domain.Loan;
import com.haulmont.creditsystem.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients() );
        return "clients/clients";
    }

    @GetMapping("/new")
    public String newClient() {
        return "clients/client_new";
    }

    @PostMapping("/new")
    public String addClient(@RequestParam(name = "name") String fullName,
                            @RequestParam(name = "phone") String phoneNumber,
                            @RequestParam(name = "email") String email,
                            @RequestParam(name = "passport") String passportNumber) {
        clientService.save(new Client(fullName, phoneNumber, email, passportNumber));
        return "redirect:";
    }

    @GetMapping("/{client}/edit")
    public String editClient(@PathVariable Client client, Model model) {
        model.addAttribute("client", client);
        return "clients/client_edit";
    }

    @PostMapping("/{uuid}/edit")
    public String updateClient(@RequestParam(name = "uuid") UUID uuid,
                               @RequestParam(name = "name") String fullName,
                               @RequestParam(name = "phone") String phoneNumber,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "passport") String passportNumber) {
        Client client = clientService.getByUuid(uuid);
        client.setFullName(fullName);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        client.setPassportNumber(passportNumber);
        clientService.save(client);
        return "redirect:/clients/";
    }

    @GetMapping("/{client}")
    public String getClient(@PathVariable Client client, Model model) {
        model.addAttribute("client", client );
        return "clients/client";
    }

    @GetMapping("/{client}/delete")
    public String deleteClient(@PathVariable Client client, Model model) {
        model.addAttribute("client", client);
        return "/clients/client_delete";
    }

    @PostMapping("/{client}/delete")
    public String deleteLoan(@PathVariable Client client) {
        clientService.delete(client);
        return "redirect:/clients/";
    }
}
