package org.Ged.orchestration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.Ged.dao.search.ClientSearchRepository;
import org.Ged.dao.search.specification.ClientSpecificationSearch;
import org.Ged.dto.ClientDto;
import org.Ged.dto.Pageable.ClientSearchPageableDto;
import org.Ged.dto.SearchRequest.ClientSearchRequestDto;
import org.Ged.model.Client;
import org.Ged.orchestration.mapper.service.MapperService;
import org.Ged.service.ClientService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@Service
public class ClientServiceSiloimp implements ClientServiceSilo {
	@Autowired
	ClientService clientService;
	@Autowired
	ClientSearchRepository clientSearchRepository;
	@Autowired
	MapperService mapperService;

	private static final String MAPPING_CLIENT = "MAPPING_CLIENT";

	@Override
	public ClientDto saveClient(ClientDto c) {
		Client clientDao = mapperService.map(c, Client.class);
		Client client = clientService.saveClient(clientDao);
		return mapperService.map(client, ClientDto.class);
	}

	@Override
	public List<ClientDto> findAllClients() {
		List<Client> client = clientService.getAllClients();
		return mapperService.mapList(client, ClientDto.class, MAPPING_CLIENT);
	}

	@Override
	public ClientDto findClientById(Long idClient) {
		Client client = clientService.findClientById(idClient);
		return mapperService.map(client, ClientDto.class);
	}

	@Override
	public Page<ClientDto> searchAll() {
		Pageable pageable = PageRequest.of(0, 10);
		return clientSearchRepository.findAll(pageable);
	}

	public void deleteClient(Long id) {
		clientService.deleteClient(id);
	}

	@Override
	public ClientDto updateClient(ClientDto c) {
		Client clientDao = mapperService.map(c, Client.class);
		Client client = clientService.updateClient(clientDao);
		return mapperService.map(client, ClientDto.class);
	}

	@Override
	public Page<ClientDto> search(ClientSearchPageableDto searchPageable) {
		Pageable pageable = PageRequest.of(searchPageable.getPage(), searchPageable.getSize());
		BoolQueryBuilder qb = getQueryBuilder(searchPageable.getClientSearchRequest());
		Optional<QueryBuilder> queryBuilder = Optional.ofNullable(qb.hasClauses() ? qb : matchAllQuery());
		if (queryBuilder.isPresent()) {
			NativeSearchQuery nativeQuery = new NativeSearchQuery(queryBuilder.get(), null,
					getSortQuery(searchPageable.getSortedBy(),searchPageable.getOrderBy()), null);
			nativeQuery.setPageable(pageable);

			return clientSearchRepository.search(nativeQuery);

		}

		return Page.empty();
	}

	private BoolQueryBuilder getQueryBuilder(ClientSearchRequestDto clientSearchRequest) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		List<QueryBuilder> totalQueries = new ArrayList<QueryBuilder>();
		if (!StringUtils.isBlank(clientSearchRequest.getNom())) {
			totalQueries.add(ClientSpecificationSearch.likeNom(clientSearchRequest.getNom()));
		}
		if (!StringUtils.isBlank(clientSearchRequest.getPrenom())) {
			totalQueries.add(ClientSpecificationSearch.likeNom(clientSearchRequest.getPrenom()));
		}
		totalQueries.forEach(elem -> boolQueryBuilder.must(elem));

		return boolQueryBuilder;
	}

	private List<SortBuilder> getSortQuery(String sortedBy, Sort.Direction orderBy) {

		SortOrder sortOrder = (orderBy == Sort.Direction.ASC) ? SortOrder.ASC : SortOrder.DESC;
		List<SortBuilder> sortBuilder = new ArrayList<>();

		switch (sortedBy) {

		case "nom":
			sortBuilder.add(SortBuilders.fieldSort("nom"));
			break;
		case "prenom":
			sortBuilder.add(SortBuilders.fieldSort("prenom"));
			break;

		}

		return sortBuilder;

	}

}
