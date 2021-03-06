package org.Ged.dto;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "ged", type = "client")
public class ClientDto {

	public ClientDto() {
		super();
	}

	public ClientDto(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public ClientDto(Long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Field(fielddata = true)
	private Long id;
	@Field(type = FieldType.Text, fielddata = true)
	private String nom;
	@Field(type = FieldType.Text, fielddata = true)
	private String prenom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
