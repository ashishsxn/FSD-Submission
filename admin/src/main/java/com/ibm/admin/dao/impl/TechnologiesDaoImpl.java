package com.ibm.admin.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibm.admin.dao.TechnologiesDao;
import com.ibm.admin.entities.Technologies;
import com.ibm.admin.repository.TechnologiesRepository;

@Component
public class TechnologiesDaoImpl implements TechnologiesDao{
	
	
	@Autowired
	private TechnologiesRepository technologiesRepository;
	
	public Iterable<Technologies> findAllTechnologies(){
		return technologiesRepository.findAll();
	}
	public void addTechnology(Technologies tech){
		technologiesRepository.save(tech);
	}
	public void deleteTech(String id){
		technologiesRepository.deleteById(id);
	}
}
