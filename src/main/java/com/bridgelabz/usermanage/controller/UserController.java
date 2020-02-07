package com.bridgelabz.usermanage.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.usermanage.dto.LoginDto;
import com.bridgelabz.usermanage.dto.Registration;
import com.bridgelabz.usermanage.model.User;
import com.bridgelabz.usermanage.services.UserServiceImpli;

@RestController
@RequestMapping("/bridgelabz")
public class UserController {
	
	@Autowired
	UserServiceImpli services;
	
	
	@PostMapping("/registerUser")
	public HttpStatus register( @RequestBody Registration register){
		
		return services.registerUser(register);
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return services.getAllUser();
	}
	
	@GetMapping("/getByID")
	public Optional<User> getUserById(@RequestParam Long id){
		return services.getUserByID(id);
	}
	
	@PutMapping("/update")
	public HttpStatus updateUserDetail(@RequestBody Registration register) {
		
		return services.updateUser(register);
	}
	
	
	@DeleteMapping("/deleteById")
	public void deleteUserById(@RequestParam Long id) {
		 services.deleteById(id);
	}
	
	@PostMapping("/login")
	public HttpStatus Login(@RequestBody LoginDto login) {
		return services.Login(login);
	}
	
}
