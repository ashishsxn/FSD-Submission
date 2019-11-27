package com.ibm.admin.resource;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ibm.admin.entities.Skills;
import com.ibm.admin.entities.Technologies;
import com.ibm.admin.entities.Users;
import com.ibm.admin.service.TechnologiesService;
import com.ibm.admin.service.UserService;
import com.ibm.admin.service.vo.MentorSignUpModel;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    TechnologiesService technologiesService;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/admins")
    public List<MentorSignUpModel> getAllAdminUserList(){
        return userService.getUserList();
    }

    @RequestMapping("/technologies")
    public List<Technologies> getTechList(){
        return technologiesService.getTechList();
    }

    @RequestMapping("/blockuser/{id}")
    public void blockUser(@PathVariable String id){
        restTemplate.getForObject("http://USER/block/"+id,Users.class);
    }
    @RequestMapping("/blockmentor/{id}")
    public void blockMentor(@PathVariable String id){
        restTemplate.getForObject("http://MENTOR/block/"+id,Users.class);
    }

    @RequestMapping("/admins/{id}")
    public Users getAdminUserListById(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping(method=RequestMethod.POST,value = "/admins")
    public void addUsers(@RequestBody MentorSignUpModel s) {
        userService.addUserDetails(s);
    }
    
    @RequestMapping(method=RequestMethod.POST,value = "/technologies")
    public void addTechnology(@RequestBody Technologies s) {
        technologiesService.addTechnology(s);
        Skills skill = new Skills(s.getTechnology());
        restTemplate.postForObject("http://MENTOR/skills",skill,Skills.class);
    }
    
    @RequestMapping(method=RequestMethod.PUT,value = "/admins/{id}")
    public void updateUser(@RequestBody Users s,@PathVariable String id){
        userService.updateUser(s,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/admins/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/technologies/{id}")
    public void deleteTech(@PathVariable String id) {
        technologiesService.deleteTech(id);
        restTemplate.delete("http://MENTOR/skills/"+id);
    }

}