package com.ibm.user.dao;

import org.springframework.stereotype.Component;

import com.ibm.user.entities.Course;

@Component
public interface CourseDao {
	public void addCourse(Course course);
	public Iterable<Course> getAllCourse();
}
