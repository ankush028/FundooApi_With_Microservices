package com.bridgelabz.notemanage.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name ="Users")
@Data
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String username;
	private Long mbNo;
	private String email;
	private String password;
	private String confirmPassword;
	@JsonIgnore
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(unique = true)
	private Address address;
	private LocalDateTime registeredDate;
	private LocalDateTime updatedDate;

	
}
