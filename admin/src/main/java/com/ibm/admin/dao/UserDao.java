package com.ibm.admin.dao;

import org.springframework.stereotype.Component;
import com.ibm.admin.entities.TrainerDetails;
import com.ibm.admin.entities.Users;

@Component
public interface UserDao {
	public Iterable<Users> finalAllUsers();
	public Users findUserById(String id);
	public void addTrainerDetails(TrainerDetails trainerDetails);
	public void addUserDetails(Users user);
	public void updateUser(Users s, String id);
	public void deleteUser(String id);
}
