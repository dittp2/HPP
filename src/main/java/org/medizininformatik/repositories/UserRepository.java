package org.medizininformatik.repositories;

import org.medizininformatik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long>{

}
