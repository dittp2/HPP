package org.medizininformatik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.medizininformatik.entities.Document;
import org.medizininformatik.entities.Right;
import java.lang.Boolean;

@Repository
public interface RightRepository extends JpaRepository<Right, Long>{
	
	//List<Right> findByHealthpId(Long healthp);

}
