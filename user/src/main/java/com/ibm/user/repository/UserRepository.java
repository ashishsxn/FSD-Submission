package com.ibm.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.user.entities.Users;

public interface UserRepository extends CrudRepository<Users, String> {

}
