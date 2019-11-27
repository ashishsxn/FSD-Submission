package com.ibm.mentor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.mentor.dao.UserDao;
import com.ibm.mentor.entities.Results;
import com.ibm.mentor.entities.TrainerDetails;
import com.ibm.mentor.entities.Users;
import com.ibm.mentor.repository.ResultsRepository;
import com.ibm.mentor.repository.TrainerDetailsRepository;
import com.ibm.mentor.repository.UserRepository;
import com.ibm.mentor.service.vo.SearchForm;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
    private UserRepository ur;
    
	@Autowired
    private TrainerDetailsRepository tdr;
    
	@Autowired
    private ResultsRepository resultsRepository;
    
    public Iterable<Users> findAllUsers(){
    	return ur.findAll();
    }
    
    public Users findUserById(String id){
    	return ur.findById(id).orElse(null);
    }
    
    public void addUserDetails(Users user){
    	ur.save(user);
    }
    
    public void addTrainerDetails(TrainerDetails trainerDetails){
		tdr.save(trainerDetails);
	}
    
    public void updateUser(Users s, String id){
		ur.save(s);
	}
	public void deleteUser(String id){
		ur.deleteById(id);
	}
	
	public List<Results> searchMentors(SearchForm s) {
		return resultsRepository.findMentors(s.getFrom(),s.getCourse(),s.getTimeslot());
	}
}
