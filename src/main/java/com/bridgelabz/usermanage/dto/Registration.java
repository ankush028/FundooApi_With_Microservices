package com.bridgelabz.usermanage.dto;

import com.bridgelabz.usermanage.model.Address;
import lombok.Data;

@Data
public class Registration {
	
	
	private String fullName;
	
	private String username;
	
	private Long mbNo;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
	private Address address;
	
}
