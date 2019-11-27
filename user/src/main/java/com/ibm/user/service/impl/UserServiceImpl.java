package com.ibm.user.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.user.dao.UserDao;
import com.ibm.user.entities.Skills;
import com.ibm.user.entities.TrainerDetails;
import com.ibm.user.entities.Users;
import com.ibm.user.service.UserService;
import com.ibm.user.service.vo.MentorSignUpModel;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDao userDao;
    
    public List<MentorSignUpModel> getUserList() {

        List<Users> userList = new ArrayList<>();
        userDao.findAllUsers().forEach(userList::add);
        List<MentorSignUpModel> formattedList = new ArrayList<>();
        for(Users t: userList) {
            Set<String> stringSkills = new HashSet<>();
            MentorSignUpModel m = new MentorSignUpModel();
            m.setEmail(t.getEmail());
            m.setEnddate(t.getTrainerDetails().getEnddate());
            m.setBlogs(t.getTrainerDetails().getBlogs());
            m.setDemos(t.getTrainerDetails().getDemos());
            m.setExperience(t.getTrainerDetails().getExperience());
            m.setLinkedin(t.getTrainerDetails().getLinkedin());
            m.setPassword(t.getPassword());
            m.setPhone(t.getPhone());
            m.setPpts(t.getTrainerDetails().getPpts());
            m.setRole(t.getRole());
            m.setStartdate(t.getTrainerDetails().getStartdate());
            m.setStatus(t.getStatus());
            m.setTimeslot(t.getTrainerDetails().getTimeslot());
            m.setTimezone(t.getTrainerDetails().getTimezone());
            m.setUserName(t.getUserName());
            m.setVideos(t.getTrainerDetails().getVideos());
            for(Skills temp: t.getSkills()) {
                stringSkills.add(temp.getSkill());
            }
            m.setSkills(stringSkills);
            formattedList.add(m);
        }

        return formattedList;


    }

    public Users getUser(String id) {

        return userDao.findUserById(id);
    }

    public void addUserDetails(MentorSignUpModel s) {
        Users user = new Users();
        TrainerDetails trainerDetails = new TrainerDetails();
        Set<Skills> skills = new HashSet<>();
        for(String skillString : s.getSkills()){
            Skills skill = new Skills();
            skill.setSkill(skillString);
            skills.add(skill);

        }
        for(Skills t: skills) {
            System.out.println(t.getSkill());
        }
        trainerDetails.setEmail(s.getEmail());
        trainerDetails.setBlogs(s.isBlogs());
        trainerDetails.setDemos(s.isDemos());
        trainerDetails.setExperience(s.getExperience());
        trainerDetails.setLinkedin(s.getLinkedin());
        trainerDetails.setPpts(s.isPpts());
        trainerDetails.setTimeslot(s.getTimeslot());
        trainerDetails.setTimezone(s.getTimezone());
        trainerDetails.setVideos(s.isVideos());
        trainerDetails.setStartdate(s.getStartdate());
        trainerDetails.setEnddate(s.getEnddate());
        userDao.addTrainerDetails(trainerDetails);
        user.setEmail(s.getEmail());
        user.setPassword(s.getPassword());
        user.setPhone(s.getPhone());
        user.setRole(s.getRole());
        user.setStatus(s.getStatus());
        user.setTrainerDetails(trainerDetails);
        user.setUserName(s.getUserName());
        user.setSkills(skills);
        userDao.addUserDetails(user);
    }


    public void updateUser(Users s, String id) {
        userDao.addUserDetails(s);
    }

    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

}
