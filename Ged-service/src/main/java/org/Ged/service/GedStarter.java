package org.Ged.service;

import org.Ged.dao.UtilisateurRepository;
import org.Ged.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "org.Ged.*")
@EnableJpaRepositories(basePackages = "org.Ged.*")
@EntityScan(basePackages = "org.Ged.*")


public class GedStarter  implements CommandLineRunner  {

	@Autowired(required = true)
	private UtilisateurService utilisateurService;



	public static void main(String[] args)  {
		System.out.println(" **** SERVICE LAYER" + Utilisateur.class);
		SpringApplication.run(GedStarter.class, args);
		// utilisateurService.saveOrUpdate(new Utilisateur(null, "afaf2", "been"));
		// user.save(new Utilisateur(null, "afaf2", "been"));
	}

	public void run(String... args) throws Exception {
		System.out.print("test before start ");
		utilisateurService.saveOrUpdate(new Utilisateur("amin", "elkilo"));
		// user.save(new Utilisateur(null, "afaf2", "been"));
		System.out.print("test before start ");
	}
}
