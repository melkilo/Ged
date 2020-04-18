package org.Ged.orchestration;

import java.util.List;

import org.Ged.dto.ClientDto;
import org.Ged.model.Client;

public interface ClientServiceSilo {
	ClientDto saveClient(ClientDto c);

	List<ClientDto> findAllClients();
}
