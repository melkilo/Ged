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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/ged")
@Api(description = "CRUD API Client")
public class ClientApi {

	@Autowired
	private ClientServiceSilo clientServiceSilo;

	@GetMapping("/getAllClients")
    @ApiOperation(value = "Get all clients from DB !")

	public List<ClientDto> getAllClients() {
		return clientServiceSilo.findAllClients();
	}

   

	@GetMapping("/getClientById/{idClient}")
	@ApiOperation(value = "Get client by id from DB !")
	public ClientDto getClientById(@PathVariable Long idClient) {
		return clientServiceSilo.findClientById(idClient);
	}

	@GetMapping("/search")
	@ApiOperation(value = "Get all clients from ES !")
	public Page<ClientDto> search() {
		return clientServiceSilo.search();
	}

	@PostMapping("/addClient")
	@ApiOperation(value = "Add new client  !")
	public ClientDto addClients(@RequestBody ClientDto client) {
		return clientServiceSilo.saveClient(client);
	}

	@DeleteMapping("/deleteClient/{id}")
	@ApiOperation(value = "Delete client !")
	public void deleteClient(@PathVariable Long id) {
		clientServiceSilo.deleteClient(id);
	}

	@PutMapping("/updateClient")
	@ApiOperation(value = "Update client !")
	public void updateClient(@RequestBody ClientDto client) {
		clientServiceSilo.updateClient(client);
	}

}
