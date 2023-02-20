package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.DAOUser;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	
}