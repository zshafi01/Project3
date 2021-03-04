package com.simplilearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entities.Customer;
import com.simplilearn.entities.Shoes;
import com.simplilearn.entities.User;
import com.simplilearn.services.CustomerService;
import com.simplilearn.services.ShoesService;
import com.simplilearn.services.UserService;

@Controller
public class InedxController {

	@Autowired
	UserService userService;

	@Autowired
	ShoesService shoesService;
	
	@Autowired
	CustomerService customerService; 

	@RequestMapping("/")
	String getall(ModelMap model) {

		List<Shoes> allShoes = shoesService.retreveAllShoesInfo();
		model.addAttribute("allShoes", allShoes);
		return "index";
	}

	@RequestMapping(path = "/signup")
	String index(ModelMap model) {
		return "SignUp";
	}

	@RequestMapping(path = "/login")
	String login(ModelMap model) {
		return "Login";
	}

	@RequestMapping(path = "/signupSave", method = RequestMethod.POST)
	public ModelAndView userForm(@ModelAttribute User user) { // display form
		boolean isSaved = userService.saveUser(user);
		System.out.print("saving.................." + isSaved);
		if(isSaved) {
		return new ModelAndView("Login");
		}else {
			return new ModelAndView("error");
		}
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView loginForm(@ModelAttribute User user) {

		User userfound = userService.getUserByEmail(user.getEmail(), user.getPassword());

		if (userfound != null) {
			if (userfound.getType().equalsIgnoreCase("admin")) {
				return new ModelAndView("AdminDashBoard");
			} else {
				Customer customer=customerService.getCustomerByUserId(userfound.getId());
				
				if(customer!=null) {
					ModelAndView modelAndView = new ModelAndView("customerprofile");
					modelAndView.addObject("customer", customer);
					return modelAndView;
				}else {
					return new ModelAndView("Login");
				}
			}

		} else {
			return new ModelAndView("Login");
		}
	}

}