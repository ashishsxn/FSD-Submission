package com.ibm.mentor.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.mentor.entities.Results;
import com.ibm.mentor.entities.TrainerDetails;
import com.ibm.mentor.entities.Users;
import com.ibm.mentor.service.vo.SearchForm;

@Component
public interface UserDao {
	public Iterable<Users> findAllUsers();
	public Users findUserById(String id);
	public void addTrainerDetails(TrainerDetails trainerDetails);
	public void addUserDetails(Users user);
	public void updateUser(Users s, String id);
	public void deleteUser(String id);
	public List<Results> searchMentors(SearchForm s);
}
