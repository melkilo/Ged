package org.Ged.service;

import org.Ged.model.Client;

import java.util.List;

import org.Ged.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository utilisateurRepository;

	@Transactional
	@Override
	public Client saveClient(Client client) {
		return utilisateurRepository.save(client);
	}

	@Transactional
	@Override
	public List<Client> getAllClients() {
		return utilisateurRepository.findAll();
	}

	@Transactional
	@Override
	public void deleteClient(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Transactional
	@Override
	public Client updateClient(Client client) {
		return utilisateurRepository.save(client);
	}

}
