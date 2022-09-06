package com.olxclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.olxclone.entity.User;
import com.olxclone.repository.UserRepository;

@Controller
public class AppController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String Viewhomepage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String ShowRegisterPage(Model model) {
		model.addAttribute("user",new User());
		return "registerpage";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		userRepository.save(user);
		return "register";
	}
}
