package org.Ged.ws.api.client;

import java.util.List;

import org.Ged.dto.ClientDto;
import org.Ged.orchestration.ClientServiceSilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ged")
public class ClientApi {

	@Autowired
	private ClientServiceSilo clientServiceSilo;
	@GetMapping("/getAllClients")
	public List<ClientDto> getAllClients() {
		return clientServiceSilo.findAllClients();
	}
	
	@GetMapping("/search")
	public Page<ClientDto> search() {
		return clientServiceSilo.search();
	}

	@PostMapping("/addClient")
	public ClientDto addClients(@RequestBody ClientDto client) {
		return clientServiceSilo.saveClient(client);
	}

	@DeleteMapping("/deleteClient/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientServiceSilo.deleteClient(id);
	}

	@PutMapping("/updateClient")
	public void updateClient(@RequestBody ClientDto client) {
		clientServiceSilo.updateClient(client);
	}

}
