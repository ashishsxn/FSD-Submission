package com.ibm.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.admin.entities.TrainerDetails;

@Repository
public interface TrainerDetailsRepository extends CrudRepository<TrainerDetails, String> {

}
