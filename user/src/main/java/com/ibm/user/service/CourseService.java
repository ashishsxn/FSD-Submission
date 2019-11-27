package com.ibm.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.user.entities.Course;

@Service
public interface CourseService {

	public void addCourse(Course course);

	public List<Course> getCourseList();
}