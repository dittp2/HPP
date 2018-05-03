package org.medizininformatik.repositories;

import java.util.List;

import org.medizininformatik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long>{

	List<User> findByFnameIgnoreCase(String fname);
	
	List<User> findByLnameIgnoreCase(String lname);
	
	List<User> findByLnameAndFnameAllIgnoreCase(String lname, String fname);
	
	List<User> findByGender(int gender);

}
