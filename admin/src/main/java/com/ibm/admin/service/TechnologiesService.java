package com.ibm.admin.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.admin.entities.Technologies;

@Component
public interface TechnologiesService {
	public List<Technologies> getTechList();
	public void addTechnology(Technologies tech);
	public void deleteTech(String id);
	
}
