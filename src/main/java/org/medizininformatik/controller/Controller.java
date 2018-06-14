package org.medizininformatik.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;


import org.medizininformatik.entities.HealthProfessional;
import org.medizininformatik.entities.Right;
import org.medizininformatik.entities.Patient;


import org.medizininformatik.entities.Document;
import org.medizininformatik.repositories.HPDirectory;
import org.medizininformatik.repositories.RightRepository;
import org.medizininformatik.repositories.PatientRepository;
import org.medizininformatik.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class Controller {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private HPDirectory hpDirectory;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private RightRepository rightRepository;
	

	/*
	 * Get all Patients from the Repository (function as MPI)
	 */
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return patientRepository.findAll();
	}
	
	/*
	 * Get all Patients, condition id, from the Repository (function as MPI)
	 */
	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable Long id) {
		return patientRepository.findOne(id);
	}
	
	/*
	 * Get all Patients, condition firstname and lastname , from the Repository (function as MPI)
	 */
	@GetMapping("/patients/{fname}&{lname}")
	public List<Patient> getPatient(@PathVariable String fname,@PathVariable String lname){
		
		List<Patient> patients = null;
		
		if(!fname.equals("")&&lname.equals("")) {	
			patients = patientRepository.findByFnameIgnoreCase(fname);
		}
		
		if(fname.equals("")&&!lname.equals("")) {
			patients = patientRepository.findByLnameIgnoreCase(lname);
		}
		
		if(!fname.equals("")&&!lname.equals("")){
			patients = patientRepository.findByLnameAndFnameAllIgnoreCase(lname, fname);
		}
		
		if(fname.equals("")&&lname.equals("")){
			patients = getPatients();
		}
				
		return patients;
	}
	
	@GetMapping("/patients/{healthp}")
	public List<Patient> getUserHealth(@PathVariable Long healthp) {		
		return patientRepository.findByHealthpId(healthp);
	}
	
	@PutMapping("/patient")
	public Patient updateUser(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@PostMapping("/patient")
	public Patient createUser(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
		
	/*
	 * Get all Documentinformation, condition id, from the DB 
	 */
	@GetMapping("/documents")
	public List<Document> getDocuments() {
		return documentRepository.findAll();
	}
	
	@GetMapping("/document/{id}")
	public Document getDocument(@PathVariable Long id) {
		return documentRepository.findOne(id);
	}
	
	/*
	 * Get all right, condition healthp, from the DB 
	 */
//	@GetMapping("/rights")
//	public List<Right> getRight() {
//		return rightRepository.findAll();
//	}
//	
//	@GetMapping("/rights/{healthp}")
//	public List<User> getRightuser(@PathVariable Long healthp) {
//		List<User> users = null;
//		 List<Right> rights = rightRepository.findByHealthpId(healthp);
//		
//		 for(int i = 0; i< rights.size();i++) {
//			 users.add(rights.get(i).getUser());
//			}
//		return users;
//				
//				
//	}

	/*
	 * Get all Health Professional, condition id, from the hpDirectory (function as HPD)
	 */
	@GetMapping("/healthProfessionals")
	public List<HealthProfessional> getHealthProfessionals() {
		return (List<HealthProfessional>) hpDirectory.findAll();
	}
	
	@GetMapping("/healthProfessional/{id}")
	public HealthProfessional getHealthProfessional(@PathVariable Long id) {
		return hpDirectory.findOne(id);
	}
	
	@GetMapping("/healthProfessionals/{login}&{pass}")
	public HealthProfessional getHealthProfessionals(@PathVariable String login, @PathVariable String pass) {
		return hpDirectory.findByLoginAndPass(login, pass);
	}

	@PostMapping("/healthProfessional")
	public HealthProfessional createHealthProfessional(@RequestBody final HealthProfessional healthProfessional) {
		return hpDirectory.save(healthProfessional);
	}
	
	@PutMapping("/healthProfessional")
	public HealthProfessional updateHealthProfessional(@RequestBody HealthProfessional healthProfessional) {
		return hpDirectory.save(healthProfessional);
	}
	
}
