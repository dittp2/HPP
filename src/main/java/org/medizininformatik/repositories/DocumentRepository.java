package org.medizininformatik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.medizininformatik.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

}
