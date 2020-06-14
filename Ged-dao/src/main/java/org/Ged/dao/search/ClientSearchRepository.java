package org.Ged.dao.search;

import org.Ged.dto.ClientDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public interface ClientSearchRepository extends  ElasticsearchRepository<ClientDto, Integer>{

}
