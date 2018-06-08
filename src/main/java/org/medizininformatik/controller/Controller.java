package org.medizininformatik.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;


import org.medizininformatik.entities.HealthProfessional;
import org.medizininformatik.entities.User;


import org.medizininformatik.entities.Document;
import org.medizininformatik.repositories.HPDirectory;
import org.medizininformatik.repositories.UserRepository;
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
	private UserRepository userRepository;
	
	@Autowired
	private HPDirectory hpDirectory;
	
	@Autowired
	private DocumentRepository documentRepository;
	

	/*
	 * Get all Patients from the Repository (function as MPI)
	 */
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/documents")
	public List<Document> getDocuments() {
		return documentRepository.findAll();
	}
	
	@GetMapping("/document/{id}")
	public Document getDocument(@PathVariable Long id) {
		return documentRepository.findOne(id);
	}
//
//	
//	@GetMapping("/get-text")
//	public @ResponseBody String getText() {
//	    return "Hello world";
//	}
	

@GetMapping(value = "/file", 
produces = MediaType.APPLICATION_PDF_VALUE)
public @ResponseBody byte[] getFile() throws IOException {
    InputStream in = getClass()
      .getResourceAsStream("Max_Muster_Kurzbericht.pdf");
    return IOUtils.toByteArray(in);
}


/*
@RequestMapping(value="/getpdf1", method=RequestMethod.GET)
public ResponseEntity<byte[]> getPDF1() {


    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    String filename = "Max_Muster_Kurzbericht.pdf";

    headers.add("content-disposition", "inline;filename=" + filename);

    headers.setContentDispositionFormData(filename, filename);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdf1Bytes , headers, HttpStatus.OK);
    return response;
}


@RequestMapping("/handle")
public ResponseEntity<String> handle() {
  URI location = "Max_Muster_Kurzbericht.pdf";
  return ResponseEntity.created(location).header("MyResponseHeader", "MyValue").body("Hello World");
}

@RequestMapping(value = "/image-byte-array", method = RequestMethod.GET)
public @ResponseBody byte[] getImageAsByteArray() throws IOException {
    InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
    return IOUtils.toByteArray(in);
}

@RequestMapping(value = "/image-response-entity", method = RequestMethod.GET)
public ResponseEntity<byte[]> getImageAsResponseEntity() {
    HttpHeaders headers = new HttpHeaders();
    InputStream in = servletContext.getResourceAsStream("image-example.jpg");
    byte[] media = IOUtils.toByteArray(in);
    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
     
    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
    return responseEntity;
}
*/

	
	/*
	 * Get all Patients, condition firstname and lastname , from the Repository (function as MPI)
	 */
	@GetMapping("/users/{fname}&{lname}")
	public List<User> getUsers(@PathVariable String fname,@PathVariable String lname){
		
		List<User> users = null;
		
		if(!fname.equals("")&&lname.equals("")) {	
			users = userRepository.findByFnameIgnoreCase(fname);
		}
		
		if(fname.equals("")&&!lname.equals("")) {
			users = userRepository.findByLnameIgnoreCase(lname);
		}
		
		if(!fname.equals("")&&!lname.equals("")){
			users = userRepository.findByLnameAndFnameAllIgnoreCase(lname, fname);
		}
		
		if(fname.equals("")&&lname.equals("")){
			users = getUsers();
		}
		
		
//		;
//		if(!gender.equals("")) {
//			 			
//			users = userRepository.findByGender(Integer.parseInt(gender));
//		}
		
		return users;
	}
	
	/*
	 * Get all Patients, condition id, from the Repository (function as MPI)
	 */
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
	
	@GetMapping("/users/{healthp}")
	public List<User> getUserHealth(@PathVariable Long healthp) {
		
		
		return userRepository.findByHealthpId(healthp);
	}
	
	

	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		userRepository.delete(id);
		return true;
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
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
