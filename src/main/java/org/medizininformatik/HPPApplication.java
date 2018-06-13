package org.medizininformatik;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.h2.util.New;
import org.hibernate.engine.jdbc.dialect.spi.DatabaseMetaDataDialectResolutionInfoAdapter;
import org.medizininformatik.entities.Document;
import org.medizininformatik.entities.HealthProfessional;
import org.medizininformatik.entities.Right;
import org.medizininformatik.entities.Patient;
import org.medizininformatik.repositories.DocumentRepository;
import org.medizininformatik.repositories.HPDirectory;
import org.medizininformatik.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class HPPApplication implements CommandLineRunner {
	
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private HPDirectory hpDirectory;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HPPApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { }
		
		@Bean
		CommandLineRunner runner(HPDirectory hpDirectory) {
			
			return args -> {				
				
				//die Dokumenten für der Patient Hugentobler mit deren Metadaten erstellt
				
				Document doc1 = (new Document("Medikation_Tom_Hugo","Medikationsplan","Psychiatrie","Psychiatriezentrum",
						" Dr.med. Zimmermann","10.04.2018", "/assets/Tom_Hugo_Medikation.pdf"));
				Document doc2 = (new Document("Bericht_Tom_Hugo","Behandlungsbericht","Psychiatrie","Psychiatriezentrum",
						" Dr.med. Zimmermann","10.04.2018", "/assets/Max_Muster_Kurzbericht.pdf"));
				
				//die Leistungsterbringer werden mit deren Informationen erstellt
				
				HealthProfessional healthp1 = (new HealthProfessional("7601000151764" , "Zimmermann", "Martin", "Dr.med.", "männlich",
						"Arzt"," ","Psychiater"," ","Münsingen"," ", "Deutsch"," ","zimmermann.martin@psych.ch","zim","pass"));
				
				HealthProfessional healthp2 = new HealthProfessional("7601008851764" , "Ganzoni", "Fabio", "Dr.med.", "männlich",
						"Arzt"," ","Notfallchirugie"," ","Bern"," ", "Deutsch"," ","ganzoni.fabio@notfall.ch","gan","pass");
				
				HealthProfessional healthp3 = new HealthProfessional("7601000154724" , "Blumen", "Eliane", "Dr. med.", "weiblich",
						"Arzt"," ","Gynokologie"," ","Insel Spital"," ", "Deutsch"," ","eliane.blumen@insel.ch","blu","pass");
				
				//die Patienten werden für das EPD Demo Tool erstellt
				Patient patient1 =new Patient("756.1234.5678.96","","Tom", "","Hugentobler", 1,new Date(75,9,03));
				
				Patient patient2 = new Patient("756.3454.3563.39","", "Astrid","Simone", "Beieler", 2,new Date(18,06,14));
				
				Patient patient3 = new Patient("756.5223.5675.45","","Christina","", "Caruso", 2,new Date(42,9,29));
				
				//die Rechtezuteilung erstellt
//				Right right1 = new Right(patient1,healthp1);
//				
//				Right right2 = new Right(patient1,healthp2);
				
				
				//die Rechte werden zu den Patient Zugeordnet
//				patient1.setHealthp(Arrays.asList(right1, right2));
				
				//die Dokument von den Hugentobler werden hinterlegt
				patient1.setDocuments(Arrays.asList(doc1, doc2));
				
				//die Leistungserbringer wird dem Patient hinterlegt
				patient1.setHealthp(Arrays.asList(healthp1, healthp2));
				patient2.setHealthp(Arrays.asList(healthp3));

				//die Leistungserbringer werden in HPDirectory Repository abgelegt.								
//				hpDirectory.save(healthp1);
//				hpDirectory.save(healthp2);
//				hpDirectory.save(healthp3);
//				hpDirectory.save(new HealthProfessional("7601000151764" , "Hubendorf", "Otto", "Dr.med.", "männlich","Arzt"," ","Neurologie"," ","KSA"," ", "Deutsch"," ","hubendorf.otto@ksa.ch","hub","pass"));
//				hpDirectory.save(new HealthProfessional("7601000141764" , "Steinert", "Markus", "Phys.", "männlich","Arzt"," ","Innere Medizin"," ","USZ"," ", "Deutsch"," ","steinert.markus@usz.ch","ste","pass"));
//				hpDirectory.save(new HealthProfessional("7601000154724" , "Berger", "Alex", "Dr. med.", "weiblich","Arzt"," ","Kardiologie"," ","Insel Spital"," ", "Deutsch"," ","berger.alex@insel.ch","ber","pass"));
//
				
				
				//Die Patienten werden in PatientRepository abgelegt
				patientRepository.save(patient1);
				patientRepository.save(patient2);
				patientRepository.save(patient3);
				
				patientRepository.save(new Patient("756.3452.3342.46","Dr.", "Markus","Peter", "Meister", 1, new Date(18,06,14)));
				patientRepository.save(new Patient("756.3424.5757.33","Herr", "Pietro","Pablo", "Golums", 1, new Date(72,06,14)));
				patientRepository.save(new Patient("756.1674.1345.98","Dr.", "Susanne","Nadia", "Rössner", 2,new Date(18,06,14)));
				patientRepository.save(new Patient("756.4564.5454.23","Prof.","Astrid","Magtehilde", "Aescher", 2, new Date(48,05,12)));
				patientRepository.save(new Patient("756.1256.5238.56","","Wolfgang", "Amadeus","Berling", 1, new Date(73,7,23)));
				patientRepository.save(new Patient("756.5223.5675.45","","Christina","", "Caruso", 2,new Date(42,9,29)));
				patientRepository.save(new Patient("756.1478.1324.61","","Denis", "","Danlicker", 1,new Date(100,01,01)));
				patientRepository.save(new Patient("756.8973.1234.26","","Erika", "","Eppener", 2,new Date(56,02,21)));
				patientRepository.save(new Patient("756.2754.5232.78","","Bruno", "","Hause", 1, new Date(75,9,03)));


			};
		}

}
