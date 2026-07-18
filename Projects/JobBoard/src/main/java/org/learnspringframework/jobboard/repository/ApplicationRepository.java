package org.learnspringframework.jobboard.repository;

import org.learnspringframework.jobboard.entities.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Applications, Long> {
}
