package com.bridgelabz.usermanage.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.bridgelabz.usermanage.dto.LoginDto;
import com.bridgelabz.usermanage.dto.Registration;
import com.bridgelabz.usermanage.model.User;
import com.bridgelabz.usermanage.repository.UserRepository;
import com.bridgelabz.usermanage.util.Jms;
import com.bridgelabz.usermanage.util.JwtToken;

@Service
public class UserServiceImpli {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JwtToken jwt;
	
	@Autowired
	Jms jms;
	
	
	ModelMapper mapper;
	
	
	public HttpStatus registerUser(Registration register){
			
		if(register.getPassword().equals(register.getConfirmPassword())){			
			mapper = new ModelMapper();
			User user = mapper.map(register,User.class);
			user.setRegisteredDate(LocalDateTime.now());
			jms.sendMail(register.getEmail(),jwt.createToken(user.getEmail()));
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
	public HttpStatus updateUser(Registration register) {
		if(register.getPassword().equals(register.getConfirmPassword())){
			Optional<User> user = userRepo.findAll().stream()
					.filter(i->i.getUsername().equals(register.getUsername())).findAny();
			if(user.isPresent()) {
				User userUpdate = user.get();
				userUpdate.setFullName(register.getFullName());
				userUpdate.setMbNo(register.getMbNo());
				userUpdate.setUsername(register.getUsername());
				userUpdate.setPassword(register.getPassword());
				userUpdate.setConfirmPassword(userUpdate.getConfirmPassword());
				userUpdate.setAddress(register.getAddress());
				userUpdate.setUpdatedDate(LocalDateTime.now());
				userRepo.save(userUpdate);
			}	
		}	
		return HttpStatus.ACCEPTED;
	}
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}
	
	public HttpStatus Login(LoginDto login) {
		Optional<User> user = userRepo.findAll().stream()
						.filter(i->i.getUsername().equals(login.getUsername())).findAny();
		if(user.isPresent()) {
			User loginuser = user.get();
			if(loginuser.getPassword().equals(login.getPassword())){
				return HttpStatus.ACCEPTED;
			}
			return HttpStatus.NON_AUTHORITATIVE_INFORMATION;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
}















