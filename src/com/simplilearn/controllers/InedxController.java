package com.simplilearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.entities.Shoes;
import com.simplilearn.entities.User;
import com.simplilearn.services.ShoesService;
import com.simplilearn.services.UserService;

@Controller
public class InedxController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShoesService shoesService;
	
	@RequestMapping("/")
	 String getall(ModelMap model) {
//		model.addAttribute("users", userService.retreveAllUser());
//get list of shoes from db
		List<Shoes> allShoes = shoesService.retreveAllShoesInfo();
		model.addAttribute("allShoes",allShoes);
		return "index";
	}

}