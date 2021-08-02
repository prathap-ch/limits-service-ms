package com.skillUp.beans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostsRepository extends JpaRepository<Posts, Integer> ,JpaSpecificationExecutor<Posts>{

}
