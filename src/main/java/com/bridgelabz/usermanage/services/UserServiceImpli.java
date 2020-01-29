package com.bridgelabz.usermanage.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.bridgelabz.usermanage.dto.Registration;
import com.bridgelabz.usermanage.model.User;
import com.bridgelabz.usermanage.repository.UserRepository;

@Service
public class UserServiceImpli {
	
	@Autowired
	UserRepository userRepo;
	
	ModelMapper mapper;
	
	
	public HttpStatus registerUser(Registration register){
			
		if(register.getPassword().equals(register.getConfirmPassword())){			
			mapper = new ModelMapper();
			User user = mapper.map(register,User.class);
			user.setRegisteredDate(LocalDateTime.now());

			userRepo.save(user);			
		return HttpStatus.CREATED;
		
		}
		return HttpStatus.NON_AUTHORITATIVE_INFORMATION;		
			
	}
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUserByID(Long id) {
		return userRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}
}
