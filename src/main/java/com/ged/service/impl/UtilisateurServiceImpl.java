package com.ged.service.impl;

import com.ged.dao.UtilisateurRepository;
import com.ged.models.Utilisateur;
import com.ged.service.inter.UtilisateurServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl  implements UtilisateurServiceInt {

    @Autowired
    UtilisateurRepository utilistaurRepository;
    @Override
    public Utilisateur addUser(Utilisateur utilisateur) {
        return utilistaurRepository.save(utilisateur);
    }
}
