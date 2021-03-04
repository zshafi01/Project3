package com.simplilearn.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.simplilearn.entities.Customer;
import com.simplilearn.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/customerlist")
	public ModelAndView listofcustomers() {
		List<Customer> list_of_customer = customerService.getAllCustomer();
		ModelAndView model = new ModelAndView("customerlist");
		model.addObject("customerlist", list_of_customer);
		return model;
	}

	@RequestMapping(path = "/customerupdate", method = RequestMethod.GET)
	public ModelAndView customerupdateForm(@RequestParam("id") String id) {
		Customer customer = customerService.getCustomerByid(id);
		ModelAndView modelAndView = new ModelAndView("customerprofile");
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}

	@RequestMapping(path = "/customerupdate", method = RequestMethod.POST)
	public ModelAndView customerupdate(@ModelAttribute Customer customer) { // display form
		boolean isupdate = customerService.saveCustomer(customer);
		System.out.print("saving.................." + customer.toString());
		if (isupdate) {

			Customer customerupdated = customerService.getCustomerByid(customer.getId());

			if (customerupdated != null) {
				ModelAndView modelAndView = new ModelAndView("customerprofile");
				modelAndView.addObject("customer", customerupdated);
				return new ModelAndView("customerprofile");
			} else {
				return new ModelAndView("error");
			}

		} else {
			return new ModelAndView("error");
		}
	}

	@RequestMapping(path = "/deletecustomer", method = RequestMethod.GET)
	public ModelAndView customerdeleteForm(@RequestParam("id") String id) { // display form
		boolean isdeleted = customerService.delete(id);

		if (isdeleted) {
			List<Customer> list_of_customer = customerService.getAllCustomer();
			ModelAndView model = new ModelAndView("customerlist");
			model.addObject("customerlist", list_of_customer);

			return model;
		} else {
			return new ModelAndView("error");
		}
	}

	@RequestMapping(path = "/changestate", method = RequestMethod.GET)
	public ModelAndView customerchangestateForm(@RequestParam("id") String id, @RequestParam("state") String state) {

		boolean stateupdated = customerService.updateState(id, state);

		if (stateupdated) {
			List<Customer> list_of_customer = customerService.getAllCustomer();
			ModelAndView model = new ModelAndView("customerlist");
			model.addObject("customerlist", list_of_customer);

			return model;
		} else {
			return new ModelAndView("error");
		}
	}

}
