package com.skillUp.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

	/*
	 * @Query("SELECT DISTINCT user FROM User user " +
	 * "JOIN FETCH user.posts posts") List<User> retrieveAll();
	 */
}
