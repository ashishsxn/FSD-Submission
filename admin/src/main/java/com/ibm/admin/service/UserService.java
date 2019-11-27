package com.ibm.admin.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.admin.entities.Users;
import com.ibm.admin.service.vo.MentorSignUpModel;

@Component
public interface UserService {
	public List<MentorSignUpModel> getUserList();
	public Users getUser(String id);
	public void addUserDetails(MentorSignUpModel s);
	public void updateUser(Users s, String id);
	public void deleteUser(String id);
}