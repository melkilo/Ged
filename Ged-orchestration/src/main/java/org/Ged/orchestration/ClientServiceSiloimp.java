package org.Ged.orchestration;

import java.util.List;

import org.Ged.dto.ClientDto;
import org.Ged.model.Client;

import org.Ged.orchestration.mapper.service.MapperService;
import org.Ged.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceSiloimp implements ClientServiceSilo {
	@Autowired
	ClientService clientService;
	@Autowired
	MapperService mapperService;

	private static final String MAPPING_CLIENT = "MAPPING_CLIENT";

	@Override
	public ClientDto saveClient(ClientDto c) {
		Client clientDao = mapperService.map(c, Client.class);
		Client client = clientService.saveClient(clientDao);
		return mapperService.map(client, ClientDto.class);
	}

	@Override
	public List<ClientDto> findAllClients() {
		List<Client> client = clientService.getAllClients();
		String t = "t";
		t.toString();
		return mapperService.mapList(client, ClientDto.class, MAPPING_CLIENT);
	}

	@Override
	public void deleteClient(Long id) {
		clientService.deleteClient(id);
	}

	@Override
	public ClientDto updateClient(ClientDto c) {
		Client clientDao = mapperService.map(c, Client.class);
		Client client = clientService.updateClient(clientDao);
		return mapperService.map(client, ClientDto.class);
	}

}
