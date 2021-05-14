package com.haulmont.creditsystem.service;

import com.haulmont.creditsystem.domain.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<Client> getAllClients();
    void save(Client client);
    Client getByUuid(UUID uuid);
    void delete(Client client);
}
