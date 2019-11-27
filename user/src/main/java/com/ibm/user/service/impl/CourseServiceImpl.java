package com.ibm.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.user.dao.CourseDao;
import com.ibm.user.entities.Course;
import com.ibm.user.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;

	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}

	public List<Course> getCourseList() {
		List<Course> courseList = new ArrayList<>();
		courseDao.getAllCourse().forEach(courseList::add);
		return courseList;
	}
}
