package org.medizininformatik.repositories;

import org.medizininformatik.entities.HealthProfessional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * HPDirectory has HealthProfessional objects.
 * The Function findByLoginAndPass will get the Healthprofessional 
 * with matching login and password
 */
@Repository
public interface HPDirectory extends CrudRepository<HealthProfessional, Long>{
	
	HealthProfessional findByLoginAndPass(String login, String pass);
}


