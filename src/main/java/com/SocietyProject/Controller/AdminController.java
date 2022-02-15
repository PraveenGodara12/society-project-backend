package com.SocietyProject.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.SocietyProject.Dao.*;
import com.SocietyProject.Exception.ResourceNotFoundException;
import com.SocietyProject.Model.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MaintenanceRepository mRepo;
	
	@Autowired
	private SocietyBillRepository bRepo;
	
	@GetMapping("/admin")
	public List<Admin> getAllAdmins(){
		return adminRepo.findAll();
	}
	@PostMapping("/admin")
	public Admin loginUser(@RequestBody Admin u){
		Admin u1 = adminRepo.findByUsername(u.getUsername());
		if(u1==null) {
			return null;
		}
		if(u1.getPassword().trim().equals(u.getPassword().trim())) {
			return u1;
		}
		return null;
	}
	
	@GetMapping("/members")
	public List<User> getMembers(){
		return userRepo.findAll();
	}
	@PostMapping("/members/{id}")
	public User addMember(@PathVariable("id") int id,@RequestBody User u){
		if(id==0)
		return userRepo.save(u);
		else {
			u.setUserID(id);
			return userRepo.save(u);
		}
	}
	@GetMapping("/members/{id}")
	public User getMemberById(@PathVariable("id") int id){
		return userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(null));
	}
	@DeleteMapping("/members/{id}")
	public List<User> deleteMember(@PathVariable("id") int id){
		User u = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(null));
		userRepo.delete(u);
		return userRepo.findAll();
	}
	@GetMapping("/societymaintenance")
	public List<MaintenanceRecord> getMaintenanceRecords(){
		return mRepo.findAll();
	}
	@PostMapping("/societymaintenance/{id}/{userID}/{billID}")
	public MaintenanceRecord addMaintenanceRecord(@PathVariable("id") int id, @PathVariable("userID") int userid, @PathVariable("billID") int billid,@RequestBody MaintenanceRecord u){
		User myuser = userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException(null));
		SocietyBillRecord sbr = bRepo.findById(billid).orElseThrow(()-> new ResourceNotFoundException(null));;
		u.setUser(myuser);
		u.setBill(sbr);
		if(id==0)
		return mRepo.save(u);
		else {
			u.setRecordID(id);
			return mRepo.save(u);
		}
	}
	
	@GetMapping("/societymaintenance/{id}")
	public MaintenanceRecord getMaintenanceRecordById(@PathVariable("id") int id){
		return mRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(null));
	}
	@GetMapping("/billRecord")
	public List<SocietyBillRecord> getBillRecords(){
		return bRepo.findAll();
	}
	@PostMapping("/billRecord")
	public SocietyBillRecord addSocietyBillRecord(@RequestBody SocietyBillRecord u){
		return bRepo.save(u);
	}
	@GetMapping("/defaulters")
	public List<MaintenanceRecord> getDefaultersRecords(){
		return mRepo.findDefaulters();
	}
	/*
	 @Scheduled(fixedDelay=(1000*60*60*24*30))
	public void schedulePenaltyForDefaulters() {
		List<MaintenanceRecord> defList = mRepo.findDefaulters();
		for(MaintenanceRecord m : defList) {
			m.setTotalAmount(m.getTotalAmount()*1.02);
			mRepo.save(m);
		}
	}
	 */
	
}
