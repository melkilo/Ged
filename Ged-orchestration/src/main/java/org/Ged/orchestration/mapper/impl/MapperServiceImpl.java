package org.Ged.orchestration.mapper.impl;

import java.util.Collection;

import org.Ged.orchestration.mapper.service.MapperService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

//import ma.cr.courrier.base.contrat.Transformable;
@Service
@Lazy(false)
public class MapperServiceImpl implements MapperService {

	/* =============================================================== */
	/* ========================== VARIABLES ========================== */
	/* =============================================================== */

	@Autowired
	private Mapper mapper;

	/* =============================================================== */
	/* ====================== UTILITIES METHODS ====================== */
	/* =============================================================== */

	/**
	 * Map a source object to a destination object function
	 * 
	 * @param source
	 *            the source object
	 * @param destination
	 *            the destination object
	 * @param mapId
	 *            the mapping reference
	 */
	@Override
	public void map(Object source, Object destination, String mapId) {
		mapper.map(source, destination, mapId);
	}

	/**
	 * Map a source object to a destination object generic function
	 * 
	 * @param source
	 *            the source object
	 * @param destinationClass
	 *            the destination object's class type
	 * @param mapId
	 *            the mapping reference
	 */
	@Override
	public <T> T map(Object source, Class<T> destinationClass, String mapId) {
		return mapper.map(source, destinationClass, mapId);
	}

	/**
	 * Map a source object to a destination object generic function without a
	 * mapping reference
	 * 
	 * @param source
	 *            the source object
	 * @param destinationClass
	 *            the destination object's class type
	 */
	@Override
	public <T> T map(Object source, Class<T> destinationClass) {
		return mapper.map(source, destinationClass);
	}

	/**
	 * Map a source object to a destination object function without a mapping
	 * reference
	 * 
	 * @param source
	 *            the source object
	 * @param destination
	 *            the destination object
	 */
	@Override
	public void map(Object source, Object destination) {
		mapper.map(source, destination);
	}

	/**
	 * Map a source collection of objects to a destination collection of objects
	 * generic function without a mapping reference
	 * 
	 * @param source
	 *            the source object's collection
	 * @param destinationClass
	 *            the destination object's class type
	 */
	@Override
	public <U, T> Collection<T> mapCollection(Collection<U> source, Class<T> destinationClass) {
		Collection<T> destination = Collections.emptyList();
		if (source != null && !source.isEmpty()) {
			destination = new ArrayList<>(source.size());
			for (U o : source) {
				destination.add(map(o, destinationClass));
			}
		}
		return destination;
	}

	/**
	 * Map a source collection of objects to a destination collection of objects
	 * generic function without a mapping reference
	 * 
	 * @param source
	 *            the source object's collection
	 * @param destination
	 *            the destination object's collection
	 * @param destinationClass
	 *            the destination object's class type
	 */
	@Override
	public <U, T> void mapCollection(Collection<U> source, Collection<T> destination, Class<T> destinationClass) {
		if (source != null && !source.isEmpty()) {
			for (U o : source) {
				destination.add(map(o, destinationClass));
			}
		}
	}

	/**
	 * Map a source collection of objects to a destination collection of objects
	 * generic function
	 * 
	 * @param source
	 *            the source object's collection
	 * @param destinationClass
	 *            the destination object's class type
	 * @param mapId
	 *            the mapping reference
	 */
	@Override
	public <U, T> Collection<T> mapCollection(Collection<U> source, Class<T> destinationClass, String mapId) {
		Collection<T> destination = Collections.emptyList();
		if (source != null && !source.isEmpty()) {
			destination = new ArrayList<>(source.size());
			for (U o : source) {
				destination.add(map(o, destinationClass, mapId));
			}
		}
		return destination;
	}

	/**
	 * Map a source collection of objects to a destination collection of objects
	 * generic function
	 * 
	 * @param source
	 *            the source object's collection
	 * @param destination
	 *            the destination object's collection
	 * @param destinationClass
	 *            the destination object's class type
	 * @param mapId
	 *            the mapping reference
	 */
	@Override
	public <U, T> void mapCollection(Collection<U> source, Collection<T> destination, Class<T> destinationClass,
			String mapId) {
		if (source != null && !source.isEmpty()) {
			for (U o : source) {
				destination.add(map(o, destinationClass, mapId));
			}
		}
	}

	@Override
	public <T> Page<T> mapPage(Page<?> pageSource, Class<T> destinationClass, String mapId) {
		return pageSource.map(source -> mapper.map(source, destinationClass, mapId));
	}

	@Override
	public <U, T> List<T> mapList(List<U> source, Class<T> destinationClass, String mapId) {
		List<T> destination = Collections.emptyList();
		if (source != null && !source.isEmpty()) {
			destination = new ArrayList<>(source.size());
			for (U o : source) {
				destination.add(map(o, destinationClass, mapId));
			}
		}
		return destination;
	}

	@Override
	public <U, T> Collection<T> mapCollection(Collection<U> source, Class<T> destinationClass, String mapId,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Map a source collection of objects to a destination collection of objects
	 * generic function with parameters
	 * 
	 * @param source
	 *            the source object's collection
	 * @param destinationClass
	 *            the destination object's class type
	 * @param mapId
	 *            the mapping reference
	 * @param params
	 *            the parameters
	 */
	// @Override
	// public <U, T> Collection<T> mapCollection(Collection<U> source,
	// Class<T> destinationClass,
	// String mapId,
	// Map<String, Object> params) {
	// Collection<T> destination = Collections.emptyList();
	// if (source != null && !source.isEmpty()) {
	// destination = new ArrayList<>(source.size());
	// for (U o : source) {
	// T d = map(o, destinationClass, mapId);
	// if (d instanceof Transformable) {
	// ((Transformable) d).computeTransformation(params);
	// }
	// destination.add(d);
	// }
	// }
	// return destination;
	// }

}
