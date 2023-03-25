package com.marketingApp.service;

import java.util.List;

import com.marketingApp.entity.Lead;

public interface LeadService {
	public void saveLead(Lead lead);
	
	List<Lead> findAllLeads();

	public void deleteLead(long id);

	public Lead findLeadById(long id);
}
