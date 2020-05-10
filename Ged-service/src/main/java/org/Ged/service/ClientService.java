package org.Ged.service;

import java.util.List;
import java.util.Optional;

import org.Ged.model.Client;
import org.springframework.data.domain.Page;

public interface ClientService {

	Client saveClient(Client client);

	List<Client> getAllClients();

	void deleteClient(Long id);

	Client updateClient(Client client);

	Client findClientById(Long idClient);
}
