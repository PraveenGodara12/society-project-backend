package com.SocietyProject.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SocietyProject.Dao.UserRepository;
import com.SocietyProject.Model.User;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
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
}
