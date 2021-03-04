package com.simplilearn.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.simplilearn.entities.Shoes;
import com.simplilearn.services.ShoesService;
import com.simplilearn.services.UserService;

@Controller
public class ShoesController {

	@Autowired
	UserService userService;

	@Autowired
	ShoesService shoesService;

	@RequestMapping("/shoeslist")
	public ModelAndView listofshoes() {
		List<Shoes> list_of_shoes = shoesService.retreveAllShoesInfo();
		ModelAndView model = new ModelAndView("shoes");
		model.addObject("shoes", list_of_shoes);
		return model;
	}

	@RequestMapping(path = "/addshoes")
	String shoes(ModelMap model) {
		model.addAttribute("shoes", new Shoes());
		return "addshoes";
	}

	@RequestMapping(path = "/addshoes", method = RequestMethod.POST)
	public ModelAndView shoesForm(@ModelAttribute Shoes shoes) { // display form
		boolean issaved = shoesService.saveShoes(shoes);
		System.out.print("saving.................." + shoes.toString());
		if (issaved) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("addshoes");
		}
	}

	@RequestMapping(path = "/updateshoes", method = RequestMethod.GET)
	public ModelAndView shoesupdateFormshow(@RequestParam("id") String id) { // display form
		Shoes shoesfound = shoesService.retreveShoesById(id);
		ModelAndView modelAndView = new ModelAndView("updateshoes");
		modelAndView.addObject("shoes", shoesfound);
		return modelAndView;
	}

	@RequestMapping(path = "/updateshoes", method = RequestMethod.POST)
	public ModelAndView shoesupdateForm(@ModelAttribute Shoes shoes) { // display form
		boolean isupdate = shoesService.updateShoes(shoes);
		System.out.print("saving.................." + shoes.toString());
		if (isupdate) {
			Shoes shoesfound = shoesService.retreveShoesById(shoes.getId());
			ModelAndView modelAndView = new ModelAndView("updateshoes");
			modelAndView.addObject("shoes", shoesfound);
			return modelAndView;
		} else {
			return new ModelAndView("error");
		}
	}

	@RequestMapping(path = "/deleteshoes", method = RequestMethod.GET)
	public ModelAndView shoesdeleteForm(@RequestParam("id") String id) { // display form
		boolean isdeleted = shoesService.deleteShoes(id);

		if (isdeleted) {
			List<Shoes> list_of_shoes = shoesService.retreveAllShoesInfo();
			ModelAndView model = new ModelAndView("shoes");
			model.addObject("shoes", list_of_shoes);
			return model;
		} else {
			return new ModelAndView("error");
		}
	}
}
