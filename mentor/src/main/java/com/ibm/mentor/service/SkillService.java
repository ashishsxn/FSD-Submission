package com.ibm.mentor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.mentor.entities.Skills;

@Service
public interface SkillService {
	public List<Skills> getSkillList();
	public void addSkills(Skills s);
	public void deleteSkill(String id);
}
