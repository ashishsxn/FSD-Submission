package com.ibm.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.admin.entities.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

}
