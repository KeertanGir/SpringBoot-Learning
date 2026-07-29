package org.learnspringframework.jobboard.repository;

import org.learnspringframework.jobboard.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByEmailIs(String email);

    Users findByFullName(String username);
}
