package com.simplilearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.entities.User;
import com.simplilearn.services.UserService;

@Controller
public class InedxController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	 String getall(ModelMap model) {
//		model.addAttribute("users", userService.retreveAllUser());

		model.addAttribute("msg","hello");
		return "index";
	}

}