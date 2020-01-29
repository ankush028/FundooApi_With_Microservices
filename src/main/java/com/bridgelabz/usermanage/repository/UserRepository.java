package com.bridgelabz.usermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.usermanage.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
