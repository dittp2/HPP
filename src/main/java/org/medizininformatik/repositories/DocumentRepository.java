package org.medizininformatik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.medizininformatik.entities.Document;

/*
 * DocumentRepository has Information about the Document and URL
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

}
