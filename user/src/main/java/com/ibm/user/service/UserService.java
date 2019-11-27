package com.ibm.user.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ibm.user.entities.Users;
import com.ibm.user.service.vo.MentorSignUpModel;

@Service
public interface UserService {

    public List<MentorSignUpModel> getUserList();
    public Users getUser(String id);
    public void addUserDetails(MentorSignUpModel s);
    public void updateUser(Users s, String id);
    public void deleteUser(String id);

}