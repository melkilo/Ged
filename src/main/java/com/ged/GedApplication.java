package com.ged;
import com.ged.models.Utilisateur;
import com.ged.service.inter.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class GedApplication implements CommandLineRunner {
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    private RepositoryRestConfiguration restConf;
    public static void main(String[] args) {
        SpringApplication.run(GedApplication.class, args);
    }

    @Override 
    public void run(String... args) throws Exception {
        utilisateurService.addUser(new Utilisateur(null, "afaf", "benidal"));
    }
}
