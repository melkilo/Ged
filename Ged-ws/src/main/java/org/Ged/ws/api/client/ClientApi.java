package org.Ged.ws.api.client;

import java.util.List;

import org.Ged.dto.ClientDto;
import org.Ged.orchestration.ClientServiceSilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/ged")
public class ClientApi {
	
	@Autowired
	private ClientServiceSilo clientServiceSilo;
	@GetMapping("/getAllClients")
	public List<ClientDto> getAllClients() {
		return clientServiceSilo.findAllClients();
	}

}
