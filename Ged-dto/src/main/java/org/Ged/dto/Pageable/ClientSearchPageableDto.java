package org.Ged.dto.Pageable;

import org.Ged.dto.SearchRequest.ClientSearchRequestDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class ClientSearchPageableDto {

	ClientSearchRequestDto clientSearchRequest;
	String sortedBy;
	Sort.Direction orderBy;
	Integer page;
	Integer size;

	public ClientSearchRequestDto getClientSearchRequest() {
		return clientSearchRequest;
	}

	public void setClientSearchRequest(ClientSearchRequestDto clientSearchRequest) {
		this.clientSearchRequest = clientSearchRequest;
	}

	public String getSortedBy() {
		return sortedBy;
	}

	public void setSortedBy(String sortedBy) {
		this.sortedBy = sortedBy;
	}

	public Direction getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Direction orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
