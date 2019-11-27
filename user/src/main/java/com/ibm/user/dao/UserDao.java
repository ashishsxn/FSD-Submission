package com.ibm.user.dao;

import org.springframework.stereotype.Component;

import com.ibm.user.entities.TrainerDetails;
import com.ibm.user.entities.Users;

@Component
public interface UserDao {
	public Iterable<Users> findAllUsers();
	public Users findUserById(String id);
	public void addUserDetails(Users user);
	public void addTrainerDetails(TrainerDetails trainerDetails);
	public void updateUser(Users s, String id);
	public void deleteUser(String id);
}
