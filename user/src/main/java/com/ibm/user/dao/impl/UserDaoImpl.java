package com.ibm.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibm.user.dao.UserDao;
import com.ibm.user.entities.TrainerDetails;
import com.ibm.user.entities.Users;
import com.ibm.user.repository.TrainerDetailsRepository;
import com.ibm.user.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository ur;

	@Autowired
	private TrainerDetailsRepository tdr;

	public Iterable<Users> findAllUsers() {
		return ur.findAll();
	}

	public Users findUserById(String id) {
		return ur.findById(id).orElse(null);
	}

	public void addUserDetails(Users user) {
		ur.save(user);
	}

	public void addTrainerDetails(TrainerDetails trainerDetails) {
		tdr.save(trainerDetails);
	}

	public void updateUser(Users s, String id) {
		ur.save(s);
	}

	public void deleteUser(String id) {
		ur.deleteById(id);
	}
}
