package org.medizininformatik;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.h2.util.New;
import org.medizininformatik.entities.Document;
import org.medizininformatik.entities.HealthProfessional;
import org.medizininformatik.entities.User;
import org.medizininformatik.repositories.DocumentRepository;
import org.medizininformatik.repositories.HPDirectory;
import org.medizininformatik.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class HPPApplication implements CommandLineRunner {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HPDirectory hpDirectory;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HPPApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception { }
		
		@Bean
		CommandLineRunner runner(HPDirectory hpDirectory) {
			
			return args -> {				
				//Add User to userRepository (List)
				userRepository.save(new User("756.1234.5678.96","","Tom", "","Hugentobler", 1,new Date(75,9,03)));
				userRepository.save(new User("756.3454.3563.39","", "Astrid","Simone", "Beieler", 2,new Date(18,06,14)));
				userRepository.save(new User("756.3452.3342.46","Dr.", "Markus","Peter", "Meister", 1, new Date(18,06,14)));
				userRepository.save(new User("756.3424.5757.33","Herr", "Pietro","Pablo", "Golums", 1, new Date(72,06,14)));
				userRepository.save(new User("756.1674.1345.98","Dr.", "Susanne","Nadia", "Rössner", 2,new Date(18,06,14)));
				userRepository.save(new User("756.4564.5454.23","Prof.","Astrid","Magtehilde", "Aescher", 2, new Date(48,05,12)));
				userRepository.save(new User("756.1256.5238.56","","Wolfgang", "Amadeus","Berling", 1, new Date(73,7,23)));
				userRepository.save(new User("756.5223.5675.45","","Christina","", "Caruso", 2,new Date(42,9,29)));
				userRepository.save(new User("756.1478.1324.61","","Denis", "","Danlicker", 1,new Date(100,01,01)));
				userRepository.save(new User("756.8973.1234.26","","Erika", "","Eppener", 2,new Date(56,02,21)));
				userRepository.save(new User("756.2754.5232.78","","Bruno", "","Hause", 1, new Date(75,9,03)));
							
				//Add Health Professionals to hpDiretory (List)
				hpDirectory.save(new HealthProfessional("7601000151764" , "Zimmermann", "Martin", "Dr.med.", "männlich","Arzt"," ","Psychiater"," ","Münsingen"," ", "Deutsch"," ","zimmermann.markus@psych.ch"));
				hpDirectory.save(new HealthProfessional("7601000141764" , "Steinert", "Markus", "Phys.", "männlich","Arzt"," ","Innere Medizin"," ","USZ"," ", "Deutsch"," ","steinert.markus@usz.ch"));
				hpDirectory.save(new HealthProfessional("7601000154724" , "Blumen", "Eliane", "Dr. med.", "weiblich","Arzt"," ","Gynokologie"," ","Insel Spital"," ", "Deutsch"," ","eliane.blumen@insel.ch"));
				
				documentRepository.save(new Document("Kurzberich_Tom_Hugo", "/assets/Max_Muster_Kurzbericht.pdf"));
				documentRepository.save(new Document("Bericht_Tom_Hugo", "/assets/Max_Muster_Kurzbericht.pdf"));

//				hpDirectory.save(new HealthProfessional("123456765432" , "Zurkinden", "Erni", "Dr. med.", "Doctor","männlich "," "," "," "," "," "," "," ", ""));
//				hpDirectory.save(new HealthProfessional("124686765431" , "Baumann", "Maria", "Dr. med.","Doctor","erer "," "," "," "," "," "," "," ",""));
//


			};
		}

}
