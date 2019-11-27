package com.ibm.mentor.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TrainerDetails {

	@Id
	@Column(length=50)
	private String email;
	private int experience;
	private String timezone;
	private String timeslot;
	private String linkedin;
	private boolean videos;
	private boolean blogs;
	private boolean ppts;
	private boolean demos;
	private Date startdate;
	private Date enddate;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerdetails_id")
	private Set<MentorSkills> mentorSkills;
	public boolean getVideos() {
		return videos;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setVideos(boolean videos) {
		this.videos = videos;
	}

	public boolean getBlogs() {
		return blogs;
	}

	public void setBlogs(boolean blogs) {
		this.blogs = blogs;
	}

	public boolean getPpts() {
		return ppts;
	}

	public void setPpts(boolean ppts) {
		this.ppts = ppts;
	}

	public boolean getDemos() {
		return demos;
	}

	public void setDemos(boolean demos) {
		this.demos = demos;
	}
	
	public TrainerDetails(){
		
	}

	public TrainerDetails(Users user, int experience, String timeZone, String timeSlot, String materialType,
			String linkedinUrl, Set<MentorSkills> mentorSkills) {
		super();
		this.experience = experience;
		this.timezone = timeZone;
		this.timeslot = timeSlot;
		this.linkedin = linkedinUrl;
		this.mentorSkills = mentorSkills;
	}

	public Set<MentorSkills> getMentorSkills() {
		return mentorSkills;
	}

	public void setMentorSkills(Set<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String id) {
		this.email = id;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timeZone) {
		this.timezone = timeZone;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeSlot) {
		this.timeslot = timeSlot;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedinUrl) {
		this.linkedin = linkedinUrl;
	}

}
