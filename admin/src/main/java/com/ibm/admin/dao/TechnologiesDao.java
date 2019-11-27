package com.ibm.admin.dao;

import org.springframework.stereotype.Component;
import com.ibm.admin.entities.Technologies;

@Component
public interface TechnologiesDao {
	public Iterable<Technologies> findAllTechnologies();
	public void addTechnology(Technologies tech);
	public void deleteTech(String id);
}
