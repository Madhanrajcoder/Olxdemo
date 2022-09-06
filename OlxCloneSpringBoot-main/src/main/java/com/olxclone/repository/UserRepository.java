package com.olxclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olxclone.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
