package org.Ged.orchestration;

import java.util.List;

import org.Ged.dto.ClientDto;
import org.Ged.dto.Pageable.ClientSearchPageableDto;
import org.Ged.model.Client;
import org.springframework.data.domain.Page;

public interface ClientServiceSilo {

	ClientDto saveClient(ClientDto c);

	List<ClientDto> findAllClients();

	Page<ClientDto> search(ClientSearchPageableDto searchPageable);

	Page<ClientDto> searchAll();

	void deleteClient(Long id);

	ClientDto updateClient(ClientDto client);

	ClientDto findClientById(Long idClient);
}
