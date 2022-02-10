package com.SocietyProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SocietyProject.Dao.AdminRepository;
import com.SocietyProject.Model.Admin;

@RestController
@RequestMapping("/api/v1/")
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;
	
	@GetMapping("/admin")
	public List<Admin> getAllAdmins(){
		return adminRepo.findAll();
	}

}
