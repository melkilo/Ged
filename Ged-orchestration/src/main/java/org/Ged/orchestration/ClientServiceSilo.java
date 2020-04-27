package org.Ged.orchestration;

import java.util.List;

import org.Ged.dto.ClientDto;
import org.Ged.model.Client;

public interface ClientServiceSilo {
	ClientDto saveClient(ClientDto client);

	List<ClientDto> findAllClients();

	void deleteClient(Long id);

	ClientDto updateClient(ClientDto client);
}
