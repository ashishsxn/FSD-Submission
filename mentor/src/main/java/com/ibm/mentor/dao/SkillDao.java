package com.ibm.mentor.dao;

import org.springframework.stereotype.Component;

import com.ibm.mentor.entities.Skills;

@Component
public interface SkillDao {
	public Iterable<Skills> findAllSkills();
	public void addSkills(Skills s);
	public void deleteSkillById(String id);
}
