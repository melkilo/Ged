package org.Ged.service;

import org.Ged.model.Client;
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
	public Client saveOrUpdate(Client utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

}
