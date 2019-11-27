package com.ibm.admin;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ibm.admin.entities.Technologies;
import com.ibm.admin.entities.Users;
import com.ibm.admin.service.TechnologiesService;
import com.ibm.admin.service.UserService;
import com.ibm.admin.service.vo.MentorSignUpModel;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
		
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@MockBean
    TechnologiesService technologiesService;
	
	
	@Ignore
	@Test
	public void retrieveAdminList() throws Exception{
		MentorSignUpModel mentorSignUpModel = new MentorSignUpModel();
		mentorSignUpModel.setBlogs(false);
		mentorSignUpModel.setDemos(false);
		mentorSignUpModel.setEmail("admintest@test.com");
		mentorSignUpModel.setExperience(0);
		mentorSignUpModel.setLinkedin(null);
		mentorSignUpModel.setPassword("admin");
		mentorSignUpModel.setPhone(null);
		mentorSignUpModel.setPpts(false);
		mentorSignUpModel.setRole("admin");
		mentorSignUpModel.setSkills(new HashSet<String>());
		mentorSignUpModel.setStatus(null);
		mentorSignUpModel.setTimeslot(null);
		mentorSignUpModel.setTimezone(null);
		mentorSignUpModel.setUserName("ADMIN");
		mentorSignUpModel.setVideos(false);
		mentorSignUpModel.setStartdate(null);
		mentorSignUpModel.setEnddate(null);
		List<MentorSignUpModel> listAdmin = new ArrayList<>();
		listAdmin.add(mentorSignUpModel);
		Mockito.when(userService.getUserList()).thenReturn(listAdmin);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admins").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String testAdminListJson = "[{\"blogs\":false,\"demos\":false,\"email\":\"admintest@test.com\",\"experience\":0,\"linkedin\":null,\"password\":\"admin\",\"phone\":null,\"ppts\":false,\"role\":\"admin\",\"skills\":[],\"status\":null,\"timeslot\":null,\"timezone\":null,\"userName\":\"ADMIN\",\"videos\":false,\"startdate\":null,\"enddate\":null}]";
		JSONAssert.assertEquals(testAdminListJson, result.getResponse().getContentAsString(), false);
		System.out.println(result.getResponse());
	}
	
	
	@Ignore
	@Test
	public void retrieveTechnologies() throws Exception{
		Technologies technologies = new Technologies();
		technologies.setTechnology("Java");
		technologies.setFee(10000);
		technologies.setCommission(10);
		List<Technologies> technologiesList = new ArrayList<>();
		technologiesList.add(technologies);
		Mockito.when(technologiesService.getTechList()).thenReturn(technologiesList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/technologies").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String testTechnologiesJson = "[{\"technology\": \"Java\", \"fee\": 10000, \"commission\": 10}]";
		JSONAssert.assertEquals(testTechnologiesJson, result.getResponse().getContentAsString(), false);
		System.out.println(result.getResponse());
	}
	
	@Test
	@Ignore
	public void retrieveAdminUserListById(){
		Users users = new Users();

	}
	
}
