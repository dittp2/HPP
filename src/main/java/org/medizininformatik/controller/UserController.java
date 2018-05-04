package org.medizininformatik.controller;

import java.util.List;


import org.medizininformatik.entities.User;
import org.medizininformatik.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	
	/*
	 * Get all Patients from the Repository (function as MPI)
	 */
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
<<<<<<< HEAD

=======
	
	/*
	 * Get all Patients, condition firstname and lastname , from the Repository (function as MPI)
	 */
	@GetMapping("/users/{fname}&{lname}&{gender}")
	public List<User> getUsers(@PathVariable String fname, @PathVariable String lname, @PathVariable String gender){
		
		List<User> users = null;
		
		if(!fname.equals("")&&lname.equals("")) {	
			users = userRepository.findByFnameIgnoreCase(fname);
		}
		
		if(fname.equals("")&&!lname.equals("")) {
			users = userRepository.findByLnameIgnoreCase(lname);
		}else {
			users = userRepository.findByLnameAndFnameAllIgnoreCase(lname, fname);
		}
		;
		if(!gender.equals("")) {
			 			
			users = userRepository.findByGender(Integer.parseInt(gender));
		}
		
		return users;
	}
	
	/*
	 * Get all Patients, condition id, from the Repository (function as MPI)
	 */
>>>>>>> 5c5211ce955bdff4a9f1e813cb16a49bdb548220
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findOne(id);
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

}
