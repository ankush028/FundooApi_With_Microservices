package com.bridgelabz.notemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NoteManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteManageApplication.class, args);
	}

}
