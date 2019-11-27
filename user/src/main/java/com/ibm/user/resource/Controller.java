package com.ibm.user.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.user.entities.Course;
import com.ibm.user.entities.Users;
import com.ibm.user.service.CourseService;
import com.ibm.user.service.UserService;
import com.ibm.user.service.vo.MentorSignUpModel;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;


    @RequestMapping("")
    public String hi() {
         return "Hi";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    

    @RequestMapping("/courses")
    public List<Course> getCourseList(){
        return courseService.getCourseList();
    }

    
    @RequestMapping(method=RequestMethod.POST,value = "/courses")
    public void addCourses(@RequestBody Course s) {
        courseService.addCourse(s);
    }
    
    @RequestMapping("/users")
    public List<MentorSignUpModel> getList(){
        return userService.getUserList();
    }

    @RequestMapping("/users/{id}")
    public Users getUserList(@PathVariable String id){
        return userService.getUser(id);
    }
    @RequestMapping("/block/{id}")
    public void blockUser(@PathVariable String id){
        Users user = userService.getUser(id);
        if(user.getStatus().equals("unblocked"))
            user.setStatus("blocked");
        else
            user.setStatus("unblocked");
        userService.updateUser(user,id);
    }

    @RequestMapping(method=RequestMethod.POST,value = "/users")
    public void addUsers(@RequestBody MentorSignUpModel s) {
         userService.addUserDetails(s);
    }
   
    
    @RequestMapping(method=RequestMethod.PUT,value = "/users/{id}")
    public void updateUser(@RequestBody Users s,@PathVariable String id){
        userService.updateUser(s,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}