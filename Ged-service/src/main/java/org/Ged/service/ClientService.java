package org.Ged.service;

import java.util.List;

import org.Ged.model.Client;

public interface ClientService {

	Client saveOrUpdate(Client utilisateur);

	List<Client> getAllClients();
}
