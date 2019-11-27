package com.ibm.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.admin.dao.TechnologiesDao;
import com.ibm.admin.entities.Technologies;
import com.ibm.admin.service.TechnologiesService;

@Component
public class TechnologiesServiceImpl implements TechnologiesService{

	@Autowired
	private TechnologiesDao technologiesDao;

	
	@Override
	public List<Technologies> getTechList() {
		List<Technologies> technologiesList = new ArrayList<>();
		technologiesDao.findAllTechnologies().forEach(technologiesList::add);
		return technologiesList;
	}
		
	@Override
	public void addTechnology(Technologies tech) {
		technologiesDao.addTechnology(tech);
	}
	
	@Override
	public void deleteTech(String id) {
		technologiesDao.deleteTech(id);
	}

}