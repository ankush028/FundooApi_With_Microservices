package com.bridgelabz.notemanage.services;

import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bridgelabz.notemanage.dto.NoteDto;
import com.bridgelabz.notemanage.model.Note;
import com.bridgelabz.notemanage.model.User;
import com.bridgelabz.notemanage.repository.NoteRepository;
import com.bridgelabz.notemanage.response.Response;

@Service
public class NoteServices {
	
	ModelMapper mapper;
	
	@Autowired
	NoteRepository noteRepo;
	 
	public void createNote(NoteDto noteDto) {
		mapper = new ModelMapper();
		Note note =mapper.map(noteDto,Note.class);
		note.setCreatedDate(LocalDateTime.now());
		noteRepo.save(note);
			
	}
	
	public List<Note> getAllNote(){
		return noteRepo.findAll();
	}
	
	public List<User> getAllUsers(){
		return getAllUser();
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
	RestTemplate restTemplate = new RestTemplate();	
	Response response =restTemplate.getForObject("http://localhost:8082/bridgelabz/getAll",Response.class);			
	return (List<User>) response.getData();
	}
}
