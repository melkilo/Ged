package org.Ged.orchestration.mapper.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

public interface MapperService {
	public void map(Object source, Object destination, String mapId);

	public <T> T map(Object source, Class<T> destinationClass, String mapId);

	public <T> T map(Object source, Class<T> destinationClass);

	public void map(Object source, Object destination);

	public <U, T> Collection<T> mapCollection(Collection<U> source, Class<T> destinationClass);

	public <U, T> void mapCollection(Collection<U> source, Collection<T> destination, Class<T> destinationClass);

	public <U, T> Collection<T> mapCollection(Collection<U> source, Class<T> destinationClass, String mapId);

	public <U, T> Collection<T> mapCollection(Collection<U> source, Class<T> destinationClass, String mapId,
			Map<String, Object> params);

	public <U, T> void mapCollection(Collection<U> source, Collection<T> destination, Class<T> destinationClass,
			String mapId);

	public <T> Page<T> mapPage(Page<?> pageSource, Class<T> destinationClass, String mapId);

	public <U, T> List<T> mapList(List<U> source, Class<T> destinationClass, String mapId);

}
