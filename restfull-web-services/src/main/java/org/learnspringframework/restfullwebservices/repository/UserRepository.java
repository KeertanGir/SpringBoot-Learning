package org.learnspringframework.restfullwebservices.repository;

import org.learnspringframework.restfullwebservices.data.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {

}
