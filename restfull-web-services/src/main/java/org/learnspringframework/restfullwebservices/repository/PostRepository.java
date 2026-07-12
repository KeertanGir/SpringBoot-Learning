package org.learnspringframework.restfullwebservices.repository;

import org.learnspringframework.restfullwebservices.data.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
