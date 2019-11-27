package com.ibm.mentor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.mentor.dao.SkillDao;
import com.ibm.mentor.entities.Skills;
import com.ibm.mentor.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	SkillDao skillDao;
	
	public List<Skills> getSkillList(){
		List<Skills> technologiesList = new ArrayList<>();
		skillDao.findAllSkills().forEach(technologiesList::add);
        return technologiesList;
	}
	
	public void addSkills(Skills s){
		skillDao.addSkills(s);
	}
	
	public void deleteSkill(String id){
		skillDao.deleteSkillById(id);
	}
}
