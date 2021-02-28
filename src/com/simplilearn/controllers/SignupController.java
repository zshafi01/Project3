package com.simplilearn.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entities.Shoes;
import com.simplilearn.entities.User;
import com.simplilearn.services.ShoesService;
import com.simplilearn.services.UserService;

@Controller
public class SignupController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShoesService shoesService;
	
	@RequestMapping(path = "/signup")
	 String index(ModelMap model) {
		return "SignUp";
	}
	@RequestMapping(path = "/login")
	 String login(ModelMap model) {
		return "Login";
	}
	
	
	@RequestMapping(path = "/signupSave", method = RequestMethod.POST)
	public ModelAndView userForm(@ModelAttribute User user){ // display form
		userService.saveUser(user);
		System.out.print("saving.................."+user.toString());
		return new ModelAndView("Login");
	}
	
	
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public ModelAndView loginForm(@ModelAttribute User user) {
		
		User userfound = userService.getUserByEmail(user.getEmail(), user.getPassword());
		
		if(userfound!=null) {
			if(userfound.getType().equalsIgnoreCase("admin")) {
				return new ModelAndView("AdminDashBoard");
			} else {
				return new ModelAndView("UserDashBoard");
			}
			
		} else {
			return new ModelAndView("Login");
		}
	}
	
	@RequestMapping(path = "/shoes")
	 String shoes(ModelMap model) {
		return "shoes";
	}
	
	@RequestMapping(path = "/shoes", method = RequestMethod.POST)
	public ModelAndView shoesForm(@ModelAttribute Shoes shoes){ // display form
		boolean issaved=shoesService.saveShoes(shoes);
		System.out.print("saving.................."+shoes.toString());
		if(issaved) {
		return new ModelAndView("redirect:/");
		}else {
			return new ModelAndView("shoes");
		}
	}
	



}
