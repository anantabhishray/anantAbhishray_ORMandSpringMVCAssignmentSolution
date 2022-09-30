package com.greatlearning.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customer.entity.Customer;
import com.greatlearning.customer.service.CustomerService;





@Controller
@RequestMapping("/Customers")
public class CustomersController {

	@Autowired
	private CustomerService CustomerService;


	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		
		List<Customer> theCustomers = CustomerService.findAll();

		theModel.addAttribute("Customers", theCustomers);

		return "list-Customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

	
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("CustomerId") int theId, Model theModel) {

		
		Customer theCustomer = CustomerService.findById(theId);

		
		theModel.addAttribute("Customer", theCustomer);

		
		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = CustomerService.findById(id);
			theCustomer.setFirstname(firstname);
			theCustomer.setLastname(lastname);
			theCustomer.setEmail(email);
		} else
			theCustomer = new Customer(firstname, lastname, email);
		
		CustomerService.save(theCustomer);

		
		return "redirect:/Customers/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("CustomerId") int theId) {

		
		CustomerService.deleteById(theId);

		
		return "redirect:/Customers/list";

	}

}
