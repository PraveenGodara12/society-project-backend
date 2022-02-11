package com.SocietyProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.SocietyProject.Dao.*;
import com.SocietyProject.Model.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/admin")
	public List<Admin> getAllAdmins(){
		return adminRepo.findAll();
	}
	
	@GetMapping("/members")
	public List<User> getMembers(){
		return userRepo.findAll();
	}
	@PostMapping("/members")
	public User addMember(@RequestBody User u){
		return userRepo.save(u);
	}
}
