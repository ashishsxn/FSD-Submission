package com.ibm.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.admin.entities.Technologies;

@Repository
public interface TechnologiesRepository extends CrudRepository<Technologies, String> {

}
