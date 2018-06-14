package org.medizininformatik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.medizininformatik.entities.Document;
import org.medizininformatik.entities.Right;
import java.lang.Boolean;
/*
 * RightRepository has Right objects
 */
@Repository
public interface RightRepository extends JpaRepository<Right, Long>{
	

}



