package com.bridgelabz.notemanage.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Notes")
@Data
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private boolean pinned;
	private boolean trashed;
	private boolean archieved;
	
//	@OneToMany(cascade = {CascadeType.ALL})
//	@JoinColumn(unique = true)
//	private List<String> collobrator;
	
	
}
