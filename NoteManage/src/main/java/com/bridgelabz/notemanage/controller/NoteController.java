package com.bridgelabz.notemanage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.notemanage.dto.NoteDto;
import com.bridgelabz.notemanage.model.Note;
import com.bridgelabz.notemanage.model.User;
import com.bridgelabz.notemanage.services.NoteServices;

@RestController
@RequestMapping(value = "/note",produces = { "application/json" })
public class NoteController {

	@Autowired
	NoteServices services;
	
	
	@PostMapping("/createNote")
	public void createNote(@RequestBody NoteDto notedto) {
		services.createNote(notedto);
	}
	@GetMapping("/getAllNote")
	public List<Note> getAllNotes(){
		return services.getAllNote();
	}
	
	@GetMapping("getAll")
	public List<User> getAll(){
		return services.getAllUsers();
	}
	
}
