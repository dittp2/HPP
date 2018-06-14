package org.medizininformatik.repositories;

import java.util.List;


import org.medizininformatik.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.data.repository.query.Param;

/*
 * PatientRepository has Patient objects 
 * There are function, which you can take as SELECT - Statements
 */
public interface PatientRepository  extends JpaRepository<Patient, Long>{

	List<Patient> findByFnameIgnoreCase(String fname);
	
	List<Patient> findByLnameIgnoreCase(String lname);
	
	List<Patient> findByLnameAndFnameAllIgnoreCase(String lname, String fname);
	
	List<Patient> findByGender(int gender);
	
	List<Patient> findByHealthpId(Long healthp);

}




