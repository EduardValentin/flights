package com.flights.api.service;

import com.flights.api.dto.ClientViewDto;
import com.flights.api.mappings.DTOMapper;
import com.flights.api.model.Client;
import com.flights.api.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final DTOMapper dtoMapper;

    public ClientService(ClientRepository clientRepository, DTOMapper dtoMapper) {
        this.clientRepository = clientRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<ClientViewDto> findAll() {

        return dtoMapper.mapList(clientRepository.findAll(), dtoMapper::toClientViewDto);
    }

    public Client create(Client client) {

        return clientRepository.save(client);
    }
}
