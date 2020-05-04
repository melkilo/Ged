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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/api/ged")
@Api(value = "CRUD API Client")
public class ClientApi {

	@Autowired
	private ClientServiceSilo clientServiceSilo;

	@GetMapping("/search")
	public Page<ClientDto> search() {
		return clientServiceSilo.search();
	}  
	
	@GetMapping("/getAllClients")
	public List<ClientDto> getAllClients() {
		return clientServiceSilo.findAllClients();
	}

	@GetMapping("/getClientById/{idClient}")
	public ClientDto getClientById(@PathVariable Long idClient) {
		return clientServiceSilo.findClientById(idClient);
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
