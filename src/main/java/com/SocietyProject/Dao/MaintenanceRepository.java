package com.SocietyProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SocietyProject.Model.*;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceRecord, Integer>{
	@Query(value = "SELECT * FROM maintenance_record WHERE userID = ?1 and year = ?2", nativeQuery = true)
	List<MaintenanceRecord> findByUserID(int userID,int year);
}
