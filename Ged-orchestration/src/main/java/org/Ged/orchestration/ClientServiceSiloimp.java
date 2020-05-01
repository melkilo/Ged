package org.Ged.orchestration;

import java.util.List;

import org.Ged.dao.search.ClientSearchRepository;
import org.Ged.dto.ClientDto;
import org.Ged.model.Client;
import org.Ged.orchestration.mapper.service.MapperService;
import org.Ged.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceSiloimp implements ClientServiceSilo {
	@Autowired
	ClientService clientService;
	@Autowired
	ClientSearchRepository clientSearchRepository;
	@Autowired
	MapperService mapperService;

	private static final String MAPPING_CLIENT = "MAPPING_CLIENT";

	@Override
	public ClientDto saveClient(ClientDto c) {
		Client clientt = mapperService.map(c, Client.class);
		Client client = clientService.saveOrUpdate(clientt);
		return clientSearchRepository.save(mapperService.map(client, ClientDto.class));
	}

	@Override
	public List<ClientDto> findAllClients() {
		List<Client> client = clientService.getAllClients();
		String t = "t";
		t.toString();
		return mapperService.mapList(client, ClientDto.class, MAPPING_CLIENT);
	}

	@Override
	public Page<ClientDto> search() {
		Pageable pageable  = PageRequest.of(0, 10);

		return clientSearchRepository.findAll(pageable);

	}

}
