package com.ibm.mentor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.mentor.entities.Results;
import com.ibm.mentor.entities.Users;
import com.ibm.mentor.service.vo.MentorSignUpModel;
import com.ibm.mentor.service.vo.SearchForm;

@Service
public interface UserService {

	public List<MentorSignUpModel> getUserList();
	public Users getUser(String id);
	public void addUserDetails(MentorSignUpModel s);
	public void updateUser(Users s, String id);
	public void deleteUser(String id);
	public List<Results> searchMentors(SearchForm s);
}