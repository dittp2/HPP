package org.medizininformatik;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.h2.util.New;
import org.medizininformatik.entities.HealthProfessional;
import org.medizininformatik.entities.User;
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
				userRepository.save(new User("Frau", "Astrid","Simone", "Beieler", 1,new Date(1918,06,14)));
				userRepository.save(new User("Herr", "Markus","Peter", "Meister", 2, new Date(18,06,14)));
				userRepository.save(new User("Herr", "Pietro","Pablo", "Golums", 2, new Date(1972,06,14)));
				userRepository.save(new User("dr", "Astmah","Blub", "Allang", 1,new Date(1918,06,14)));
				userRepository.save(new User("","Astrid","", "Aescher", 2, new Date(48,05,12)));
				userRepository.save(new User("","Bruno", "","Berling", 1, new Date(73,7,23)));
				userRepository.save(new User("","Christina","", "Caruso", 2,new Date(42,9,29)));
				userRepository.save(new User("","Denis", "","Danlicker", 1,new Date(100,01,01)));
				userRepository.save(new User("","Erika", "","Eppener", 2,new Date(56,02,21)));
				userRepository.save(new User("","Bruno", "","Hause", 1, new Date(75,9,03)));
							
				//Add Health Professionals to hpDiretory (List)
				hpDirectory.save(new HealthProfessional("123456765432" , "Zurkinden", "Erni", "Dr. med."));
				hpDirectory.save(new HealthProfessional("124686765431" , "Baumann", "Maria", "Dr. med."));


			};
		}
}
