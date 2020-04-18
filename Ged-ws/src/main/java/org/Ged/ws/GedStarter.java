package org.Ged.ws;

import java.util.List;

import org.Ged.dao.ClientRepository;
import org.Ged.dto.ClientDto;
import org.Ged.model.Client;
import org.Ged.orchestration.ClientServiceSilo;
import org.Ged.service.ClientService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "org.Ged.*")
@EnableJpaRepositories(basePackages = "org.Ged.*")
@EntityScan(basePackages = "org.Ged.*")


public class GedStarter  implements CommandLineRunner  {

	@Autowired(required = true)
	private ClientServiceSilo clientServiceSilo;


	public static void main(String[] args)  {
		SpringApplication.run(GedStarter.class, args);
	}

	public void run(String... args) throws Exception {
		
		System.out.print("<< test before start orch ");
		DozerBeanMapper mapper= new DozerBeanMapper();
		System.out.println(" <<<<<<<<<<<<  "+mapper.getMappingFiles());
		Client client=new Client("dernier", "dernier");
		ClientDto clientDto= mapper.map(client, ClientDto.class);
		clientDto=clientServiceSilo.saveClient(clientDto);
		System.out.println(clientDto.getNom()+" " +clientDto.getPrenom());
		List<ClientDto> listClient= clientServiceSilo.findAllClients();		
		for (ClientDto clientDtoo : listClient) {
			System.out.println(clientDtoo.getNom());
		}
		System.out.print("<<< test after start  orxh");
	}
}
