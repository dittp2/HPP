package org.medizininformatik.repositories;

import org.medizininformatik.entities.HealthProfessional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HPDirectory extends CrudRepository<HealthProfessional, Long>{


	HealthProfessional findByLoginAndPass(String login, String pass);

}
