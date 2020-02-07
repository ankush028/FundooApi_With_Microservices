package com.bridgelabz.usermanage.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name ="Users")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String username;
	private Long mbNo;
	private String email;
	private String password;
	private String confirmPassword;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(unique = true)
	private Address address;
	private LocalDateTime registeredDate;
	private LocalDateTime updatedDate;
	

	
	
	
	
	
	
}
