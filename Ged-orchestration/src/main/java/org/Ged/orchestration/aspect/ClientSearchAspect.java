package org.Ged.orchestration.aspect;

import org.Ged.dao.search.ClientSearchRepository;
import org.Ged.dto.ClientDto;
//import org.Ged.orchestration.mapper.service.MapperService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
//@Slf4j
public class ClientSearchAspect {

	@Autowired
	ClientSearchRepository clientSearchRepository;

	@AfterReturning(pointcut = "execution(* org.Ged.orchestration.ClientServiceSiloimp.saveClient(..))", returning = "client")
	public void saveClientTest(ClientDto client) {
		System.out.println(" <<<<<<<<<<<< insert client in elasticSearch >>>>>>>>>>>>>" + client);
		clientSearchRepository.save(client);
	}


	@AfterReturning(pointcut = "execution(* org.Ged.orchestration.ClientServiceSiloimp.deleteClient(..)) && args(idClient)")
	public void deleteClient(JoinPoint jp, Long idClient) {
		System.out.println("<<<<<<<<<<<< delete client in elasticsearch >>>>>>>>>>>>>: " + idClient);
		clientSearchRepository.deleteById(idClient.intValue());
	}

	@AfterReturning(pointcut = "execution(* org.Ged.orchestration.ClientServiceSiloimp.updateClient(..)) && args(client)")
	public void updateeClient(JoinPoint jp, ClientDto client) {
		System.out.println("<<<<<<<<<<<< update client in elasticSearch >>>>>>>>>>>>>: " + client);
		clientSearchRepository.save(client);
	}

}
