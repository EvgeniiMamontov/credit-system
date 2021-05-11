package com.haulmont.creditsystem.service.impl;

import com.haulmont.creditsystem.domain.Client;
import com.haulmont.creditsystem.repository.ClientRepository;
import com.haulmont.creditsystem.service.ClientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getByUuid(UUID uuid) {
        return clientRepository.findByUuid(uuid);
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        clientRepository.deleteByUuid(uuid);
    }
}
