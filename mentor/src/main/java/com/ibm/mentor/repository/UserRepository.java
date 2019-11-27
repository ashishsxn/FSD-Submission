package com.ibm.mentor.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.mentor.entities.Users;

public interface UserRepository extends CrudRepository<Users, String> {

}
