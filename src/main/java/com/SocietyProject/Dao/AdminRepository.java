package com.SocietyProject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SocietyProject.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	@Query(value = "SELECT * FROM admin WHERE username = ?1", nativeQuery = true)
	Admin findByUsername(String username);
	
}
