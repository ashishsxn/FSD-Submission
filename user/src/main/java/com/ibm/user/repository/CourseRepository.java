package com.ibm.user.repository;

import com.ibm.user.entities.Course;
import org.springframework.data.repository.CrudRepository;


//import com.ibm.entities.Trainings;
//import com.ibm.entities.Users;

public interface CourseRepository extends CrudRepository<Course, String> {

}
