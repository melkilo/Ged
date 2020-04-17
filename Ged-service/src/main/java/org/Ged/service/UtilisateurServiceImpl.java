package org.Ged.service;

import org.Ged.model.Utilisateur;
import org.Ged.dao.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurRepository  utilisateurRepository;
	
	@Transactional
	@Override
	public Utilisateur saveOrUpdate(Utilisateur utilisateur) {
		
		return utilisateurRepository.save(utilisateur);
	}

}
