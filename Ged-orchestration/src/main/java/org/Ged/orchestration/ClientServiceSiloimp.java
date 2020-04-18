package org.Ged.orchestration;

import org.Ged.dto.ClientDto;
import org.Ged.model.Client;
import org.Ged.service.ClientService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceSiloimp implements ClientServiceSilo {
	@Autowired
	ClientService clientService;
	private static final String MAPPING_CLIENT = "MAPPING_CLIENT";
	DozerBeanMapper  mapper = new DozerBeanMapper();
	@Override
	public ClientDto saveClient(Client c) {
		Client client = clientService.saveOrUpdate(c);
		return mapper.map(client, ClientDto.class);
	}

}
