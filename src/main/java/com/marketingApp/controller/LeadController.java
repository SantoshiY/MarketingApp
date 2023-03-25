package com.marketingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingApp.dto.LeadDto;
import com.marketingApp.entity.Lead;
import com.marketingApp.service.LeadService;
import com.marketingApp.util.EmailService;

@Controller
public class LeadController {
	//http://localhost:8080/viewLeadController
	
	@Autowired
	private EmailService es;  //this is for sending mail when record is save
	
	@Autowired
	private LeadService ls;   //here spring boot create object of LeadServiceImpl(coz we write @service in this class so it become a special class(if we dont give @service then it will give null point exception coz ls is null)) and its address is stored in ls
	
	//it will work as a @webservlet
	@RequestMapping("/viewLeadController")
	public String viewLeadController() {
		return "create_registration"; //it will work as a requestDispacher 
		
	}
	
	/*
	//store the data in database 
	
	@RequestMapping("/savelead")
	public String saveOneLead(Lead lead) {  //Lead is entity class and lead is its object created for storing all the data which we enter in form(jsp) 
		//System.out.println(lead.getFirstName());
		//System.out.println(lead.getLastName());
		//System.out.println(lead.getEmail());
		//System.out.println(lead.getMobile());   //it ll write the data on console(we can check here data is coming or not)
		
		//here ls calling saveLead(interface LeadService) from service layer 
		ls.saveLead(lead);
		return "create_registration";
	}
	*/
	
	/*
	//second way to store the data in database
	
	@RequestMapping("/savelead")
	public String saveOneLead(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobile") long mobile ) {
		//System.out.println(firstName);  //print the data on console and check its working or not!
		
		Lead l = new Lead();
		l.setFirstName(firstName);
		l.setLastName(lastName);
		l.setEmail(email);
		l.setMobile(mobile);
		ls.saveLead(l);
		return "create_registration";
		
	}
	*/

	//3rd way to store the data in data base
	/*
	@RequestMapping("/savelead")
	//whatever data we give in form here "l" will read it and store in one object and its object address is present in lead(before lead(it can be anything) variable we write entity class name)
	public String saveOneLead(@ModelAttribute("l") Lead lead, ModelMap model) {
		ls.saveLead(lead);
		//it will work as a set attribute (ModelMap)
		model.addAttribute("msg", "record is save!!");
		return"create_registration";
	}
	*/
	
	
	//4th way to stored the data in db
	@RequestMapping("/savelead")
	public String saveOneLead(LeadDto leadDto, ModelMap model) {
		Lead l = new Lead();
		l.setFirstName(leadDto.getFirstName());
		l.setLastName(leadDto.getLastName());
		l.setEmail(leadDto.getEmail());
		l.setMobile(leadDto.getMobile());
		ls.saveLead(l);
		
		
		//for sending the email
		es.sendEmail(leadDto.getEmail(), "Lead save successfully", "Welcome "+leadDto.getFirstName()+"!!!");
		
		model.addAttribute("msg", "record is save!!");
		return"create_registration";
	}
	
	//localhost:8080/listleads
	//for reading the data in form of table on browser
	
	@RequestMapping("/listleads")
	public String getAllLeads(Model model) {
		List<Lead> leads = ls.findAllLeads();
		model.addAttribute("leads",leads);//it will stored the data in form of object from the database
		return "list_leads";	
	}
	//for detele the record
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, Model model) {
		ls.deleteLead(id);
		
		List<Lead> leads = ls.findAllLeads();
		model.addAttribute("leads",leads);
		return "list_leads";
	}
	
	//find the record by id number
	@RequestMapping("/update")
	public String findOneLead(@RequestParam("id") long id, Model model) {
		Lead lead = ls.findLeadById(id);//using id first get the record the perform a update operation on it.
		model.addAttribute("lead",lead);
		return "update_lead";
	}
	
	//update the record
	@RequestMapping("/updateLead")
	public String updateOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		ls.saveLead(lead);//(save method in crud)save and update data in crud operations
		
		List<Lead> leads = ls.findAllLeads();
		model.addAttribute("leads",leads);
		return "list_leads";
	}
}