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
		if(u1.getPassword().trim().equalsIgnoreCase(u.getPassword().trim())) {
			return u1;
		}
		return null;
	}
	@GetMapping("/maintenance/{id}/{year}")
	public List<MaintenanceRecord> getUserMaintenance(@PathVariable("id") int id,@PathVariable("year") int year){
		List<MaintenanceRecord> mylist = mRepo.findByUserID(id,year);
		if(mylist.size()==0) {
			return new ArrayList<MaintenanceRecord>();
		}
		System.out.println(mylist.get(0).getMonth());
		return mylist;
	}
	@GetMapping("/bill")
	public List<SocietyBillRecord> getSocietyBillRecords(){
		return sbRepo.findAll();
	}
}
