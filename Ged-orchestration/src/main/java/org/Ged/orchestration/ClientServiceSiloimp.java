package org.Ged.orchestration;

import java.util.List;

import org.Ged.dto.ClientDto;
import org.Ged.model.Client;
import org.Ged.orchestration.mapper.service.MapperService;
import org.Ged.service.ClientService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceSiloimp implements ClientServiceSilo {
	@Autowired
	ClientService clientService;
	@Autowired
	MapperService mapperService;
	
	private static final String MAPPING_CLIENT = "MAPPING_CLIENT";
	//DozerBeanMapper mapper= new DozerBeanMapper() ;

	@Override
	public ClientDto saveClient(ClientDto c) {
		Client clientt=mapperService.map(c, Client.class);
		Client client = clientService.saveOrUpdate(clientt);
		return mapperService.map(client, ClientDto.class);
	}


	@Override
	public List<ClientDto> findAllClients() {
		List<Client> client = clientService.getAllClients();
		String t="t";
		t.toString();
		return  mapperService.mapList(client, ClientDto.class,MAPPING_CLIENT);
	}

}
