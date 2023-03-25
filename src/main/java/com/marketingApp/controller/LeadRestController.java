package com.marketingApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingApp.entity.Lead;
import com.marketingApp.repositories.LeadRepository;


@RestController

//localhost:8080/api/leads
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
		
	@GetMapping
	public List<Lead> getAllLead(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead){
		 leadRepo.save(lead);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead l) {
		leadRepo.save(l);
	}
	
	//localhost:8080/api/leads/9
	@DeleteMapping("/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);		
	}
	
	@GetMapping("/{id}")
	public Lead getOneRecord(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead l =findById.get();
		return l; //it will convert into json object
	}

}
