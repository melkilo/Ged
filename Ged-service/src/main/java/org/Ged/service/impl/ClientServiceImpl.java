package org.Ged.service.impl;

import org.Ged.model.Client;
import org.Ged.service.ClientService;
import org.Ged.service.exception.clientException;

import java.util.List;
import java.util.Optional;

import org.Ged.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Transactional
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Transactional
	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Transactional
	@Override
	public Client findClientById(Long idClient) {
		return clientRepository.findById(idClient)
				.orElseThrow(() -> new clientException(clientException.clientExceptionEnum.CLIENT_ID_NOT_FOUND));
	}

	@Transactional
	@Override
	public void deleteClient(Long idClient) {
		findClientById(idClient);
		clientRepository.deleteById(idClient);
	}

	@Transactional
	@Override
	public Client updateClient(Client client) {
		findClientById(client.getId());
		return clientRepository.save(client);
	}
	
	
	
	

}
