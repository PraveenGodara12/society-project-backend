package com.SocietyProject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SocietyProject.Model.SocietyBillRecord;
import com.SocietyProject.Model.User;

@Repository
public interface SocietyBillRepository extends JpaRepository<SocietyBillRecord, Integer>{

}
