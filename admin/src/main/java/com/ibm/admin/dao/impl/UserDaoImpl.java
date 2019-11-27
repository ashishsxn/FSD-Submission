package com.ibm.admin.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.admin.dao.UserDao;
import com.ibm.admin.entities.TrainerDetails;
import com.ibm.admin.entities.Users;
import com.ibm.admin.repository.TrainerDetailsRepository;
import com.ibm.admin.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private TrainerDetailsRepository tdr;
	
	
	public Iterable<Users> finalAllUsers(){
		return ur.findAll();
	}
	public Users findUserById(String id){
		return ur.findById(id).orElse(null);
	}
	public void addTrainerDetails(TrainerDetails trainerDetails){
		tdr.save(trainerDetails);
	}
	public void addUserDetails(Users user){
		ur.save(user);
	}
	public void updateUser(Users s, String id){
		ur.save(s);
	}
	public void deleteUser(String id){
		ur.deleteById(id);
	}
	
}
