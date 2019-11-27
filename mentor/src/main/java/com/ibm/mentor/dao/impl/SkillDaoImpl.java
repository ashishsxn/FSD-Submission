package com.ibm.mentor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.mentor.dao.SkillDao;
import com.ibm.mentor.entities.Skills;
import com.ibm.mentor.repository.SkillsRepository;

@Component
public class SkillDaoImpl implements SkillDao{
	
	@Autowired
    SkillsRepository skillsRepository;
	
	public Iterable<Skills> findAllSkills(){
		return skillsRepository.findAll();
	}
	
	public void addSkills(Skills s){
		skillsRepository.save(s);
	}
	
	public void deleteSkillById(String id){
		skillsRepository.deleteById(id);
	}
}
