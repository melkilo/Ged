package org.Ged.dao.aspect;

import org.Ged.dao.search.ClientSearchRepository;
import org.Ged.dto.ClientDto;
import org.Ged.orchestration.mapper.service.MapperService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ClientSearchAspect {
	
	@Autowired
	ClientSearchRepository clientSearchRepository;
	
	@Autowired
	MapperService mapperService;
	
	@AfterReturning(pointcut="execution(* org.springframework.data.jpa.repository.JpaRepository+.save(..))",
			returning="client")
	 public void saveClient(Object client) { 
		
		System.out.println("*****************AFTER SAVE BDD aspect "+client);
		clientSearchRepository.save(mapperService.map(client, ClientDto.class));
		//clientSearchRepository.save(mapperService.map(client, ClientDto.class));
		System.out.println("*****************AFTER SAVE ES aspect "+client);
	}

}
