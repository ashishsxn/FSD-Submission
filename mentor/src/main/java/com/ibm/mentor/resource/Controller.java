package com.ibm.mentor.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.mentor.entities.Results;
import com.ibm.mentor.entities.Skills;
import com.ibm.mentor.entities.Users;
import com.ibm.mentor.service.SkillService;
import com.ibm.mentor.service.UserService;
import com.ibm.mentor.service.vo.MentorSignUpModel;
import com.ibm.mentor.service.vo.SearchForm;

@RestController
public class Controller {

    @Autowired
    UserService userService;
    
    @Autowired
    SkillService skillService;

   
    @RequestMapping("")
    public String hi() {
        return "Hi";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping("/mentors")
    public List<MentorSignUpModel> getList(){
        return userService.getUserList();
    }

   
    @RequestMapping("/mentors/{id}")
    public Users getUserList(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping("/block/{id}")
    public void blockMentor(@PathVariable String id){
        Users user = userService.getUser(id);
        if(user.getStatus().equals("unblocked"))
            user.setStatus("blocked");
        else
            user.setStatus("unblocked");
        userService.updateUser(user,id);
    }


    @RequestMapping(method=RequestMethod.POST,value = "/mentors")
    public void addUsers(@RequestBody MentorSignUpModel s) {

        userService.addUserDetails(s);
    }
   
    @RequestMapping(method=RequestMethod.POST,value = "/search")
    public List<Results> searchMentors(@RequestBody SearchForm s) {
        return userService.searchMentors(s);
    }
    
    @RequestMapping("/skills")
    public List<Skills> getSkillList(){ 
        return skillService.getSkillList();
    }
    
    @RequestMapping(method=RequestMethod.POST,value = "/skills")
    public void addSkills(@RequestBody Skills s) {
        skillService.addSkills(s);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/skills/{id}")
    public void deleteSkill(@PathVariable String id) {
        skillService.deleteSkill(id);
    }
    
    @RequestMapping(method=RequestMethod.PUT,value = "/mentors/{id}")
    public void updateUser(@RequestBody Users s,@PathVariable String id){
        userService.updateUser(s,id);
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "/mentors/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

   

}