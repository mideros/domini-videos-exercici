package com.mideros.videos;

import java.util.Date;
import java.util.List;

/**
 * This class contains the attributes and methods of a a user
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 */

public class UserVideo {
	
	private String name;
	private String surname;
	private String userName;
	private String password;
	private Date registrationDate;
	private List<Video> videos;
	
	public UserVideo() {
		super();
	}

	public UserVideo(String name, String surname, String userName, String password, Date registrationDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
		this.registrationDate = registrationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
