package com.marketingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingApp.entity.Lead;

//here we extend jpaRepository coz it have pagination technique
public interface LeadRepository extends JpaRepository<Lead, Long> {
	
}
