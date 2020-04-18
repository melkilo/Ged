package org.Ged.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
	private Long id;
	private String nom;
	private String prenom;
}
