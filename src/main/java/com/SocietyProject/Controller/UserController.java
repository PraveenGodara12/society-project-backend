package com.SocietyProject.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.SocietyProject.Dao.*;
import com.SocietyProject.Model.*;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MaintenanceRepository mRepo;
	
	@Autowired
	private SocietyBillRepository sbRepo;
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	@PostMapping("/user")
	public User loginUser(@RequestBody User u){
		User u1 = userRepo.findByUsername(u.getUsername());
		if(u1==null) {
			return null;
		}
		if(u1.getPassword().trim().equals(u.getPassword().trim())) {
			return u1;
		}
		return null;
	}
	@GetMapping("/maintenance/{id}")
	public List<MaintenanceRecord> getUserMaintenance(@PathVariable("id") int id){
		List<MaintenanceRecord> mylist = mRepo.findByUserID(id);
		if(mylist.size()==0) {
			return new ArrayList<MaintenanceRecord>();
		}
		return mylist;
	}
	@GetMapping("/bill")
	public List<SocietyBillRecord> getSocietyBillRecords(){
		return sbRepo.findAll();
	}
}
