package org.Ged.dao.search.specification;

import org.elasticsearch.index.query.QueryBuilder;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;

public interface ClientSpecificationSearch {

	static final String NOM = "nom";
	static final String PRENOM = "prenom";

	public static QueryBuilder likeNom(String nom) {

		return boolQuery().should(matchQuery(NOM, nom));

	}

	public static QueryBuilder likePrenom(String prenom) {

		return boolQuery().should(matchQuery(PRENOM, prenom));

	}

}
