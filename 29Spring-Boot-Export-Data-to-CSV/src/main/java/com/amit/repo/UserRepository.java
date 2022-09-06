package com.amit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amit.model.Person;

public interface UserRepository extends JpaRepository<Person, Integer> {
	public static final String FIND_PROJECTS = "select username as User_name,first_name as First,last_name as Last from user_details";

	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public List<Object[]> findUserDetails(); 
}