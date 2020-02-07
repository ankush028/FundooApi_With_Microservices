package com.bridgelabz.notemanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.notemanage.model.Note;


public interface NoteRepository extends JpaRepository<Note,Long>{

}
