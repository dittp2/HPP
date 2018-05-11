package org.medizininformatik.repositories;

import java.util.List;
import org.medizininformatik.entities.HealthProfessional;
import org.medizininformatik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HPDirectory extends CrudRepository<HealthProfessional, Long>{

}
