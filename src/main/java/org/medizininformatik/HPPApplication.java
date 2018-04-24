package org.medizininformatik;

import org.medizininformatik.entities.User;
import org.medizininformatik.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HPPApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HPPApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Astrid", "Aescher", "weiblich", "12.05.1948"));
		userRepository.save(new User("Bruno", "Berling", "männlich", "23.07.1973"));
		userRepository.save(new User("Christina", "Caruso", "weiblich", "29.09.1942"));
		userRepository.save(new User("Denis", "Danlicker", "männlich", "01.01.2000"));
		userRepository.save(new User("Erika", "Eppener", "weiblich", "21.02.1956"));
		
	}
}
