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

import com.simplilearn.entities.User;
import com.simplilearn.services.UserService;

@Controller
public class SignupController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/signup")
	 String get(ModelMap model) {
		return "SignUp";
	}
	
	@RequestMapping(path = "/signupSave", method = RequestMethod.POST)
	public ModelAndView userForm(@ModelAttribute User user){ // display form
		userService.saveUser(user);
		System.out.print("saving.................."+user.toString());
		return new ModelAndView("Login");
	}
//
//	@RequestMapping("/")
//	public ModelAndView home(){
//		List<User> list_of_users = userService.retreveAllUserInfo();
//		ModelAndView model = new ModelAndView("index");
//		model.addObject("users", list_of_users);
//		return model;// logical view name + model
//	}
//	
//	@RequestMapping("/new")
//	public String userForm(Map<String, Object> model){ // display form
//		User user = new User();
//		model.put("user", user);
//		return "new_user"; // logical view name
//	}
////	
//	@RequestMapping(value="/save", method=RequestMethod.POST)
//	public String createCustomer(@ModelAttribute("user") User user){
//		userService.saveUser(user);
//		return "redirect:/"; // list of user page
//	}
//	
//	@RequestMapping("/edit")
//	public ModelAndView editCustomer(@RequestParam String id){
//		ModelAndView modelAndView = new ModelAndView("edit_user");
//		User user = userService.retreveUserById(id);
//		modelAndView.addObject("user", user);
//		return modelAndView;
//	}
//	
//	@RequestMapping("/delete")
//	public String deleteCustomer(@RequestParam String id){
//		userService.deleteUser(id);
//		return "redirect:/";
//	}


}
