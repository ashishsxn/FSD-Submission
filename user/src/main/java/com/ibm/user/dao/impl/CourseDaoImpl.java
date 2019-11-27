package com.ibm.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibm.user.dao.CourseDao;
import com.ibm.user.entities.Course;
import com.ibm.user.repository.CourseRepository;

@Component
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private CourseRepository courseRepository;

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public Iterable<Course> getAllCourse() {
		return courseRepository.findAll();
	}
}
