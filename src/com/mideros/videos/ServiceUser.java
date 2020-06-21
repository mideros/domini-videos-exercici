package com.mideros.videos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains the necessary methods to add a new user, login and show
 * users and the video list of each one..
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * @throws NullPointerException Uninitialized object
 */

public class ServiceUser {

	private Scanner lector;
	private UserVideo userV;
	private UserVideo userS;
	private Video video;
	private Calendar registerDate;
	private List<UserVideo> userList;
	private List<Video> videoList;
	private DataValidation validObj;

	public ServiceUser() {

		lector = new Scanner(System.in);
		registerDate = Calendar.getInstance();
		userList = new ArrayList<UserVideo>();
		validObj = new DataValidation();
	}

	public void registerUser() {

		userV = new UserVideo();

		System.out.println("---Register User---");

		String name = addName();
		boolean validateName = validObj.verifyText(name);

		while (!validateName) {
			name = addName();
			validateName = validObj.verifyText(name);
		}
		userV.setName(name);

		Date dateR = registerDate.getTime();
		userV.setRegistrationDate(dateR);

		String surname = addSurname();
		boolean validateSurname = validObj.verifyText(surname);

		while (!validateSurname) {
			surname = addSurname();
			validateSurname = validObj.verifyText(surname);
		}
		userV.setSurname(surname);

		String userName = addUserName();

		boolean validateUserName = validObj.verifyData(userName);

		while (!validateUserName) {
			userName = addUserName();
			validateUserName = validObj.verifyData(userName);
		}

		boolean repeatV = repeatedUsername(userName);

		while (repeatV) {
			System.out.println("Already exists, try a different username!");
			userName = addUserName();
			validateUserName = validObj.verifyData(userName);
			repeatV = repeatedUsername(userName);
		}
		userV.setUserName(userName);

		String passwordU = addPassword();
		boolean validatePassword = validObj.validatePassword(passwordU);

		while (!validatePassword) {

			passwordU = addPassword();
			validatePassword = validObj.validatePassword(passwordU);
		}
		userV.setPassword(passwordU);

		userList.add(userV);

	}

	public void loginUser() {

		userS = new UserVideo();

		if (!userList.isEmpty()) {
			String userName = addUserName();
			boolean validateUserName = validObj.verifyData(userName);

			while (!validateUserName) {
				userName = addUserName();
				validateUserName = validObj.verifyData(userName);
			}

			String passwordU = addPassword();
			boolean validatePassword = validObj.validatePassword(passwordU);

			while (!validatePassword) {
				passwordU = addPassword();
				validatePassword = validObj.validatePassword(passwordU);
			}

			if (validateLogin(userName, passwordU)) {

				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getUserName().equals(userName)) {
						userS = userList.get(i);
						videoOptions(userS);
						break;
					}
				}
			} else {
				System.out.println("Wrong username or password, please try again.");
			}
		} else {
			System.out.println("No registered users!");
			System.out.println("");
		}
	}

	public boolean repeatedUsername(String userName) {

		boolean vRepeat = false;

		for (int j = 0; j < userList.size(); j++) {
			if ((userList.get(j).getUserName().equals(userName))) {
				vRepeat = true;
				break;
			} else {
				vRepeat = false;
			}
		}
		return vRepeat;
	}

	public boolean validateLogin(String userName, String passwordU) {

		boolean vLogin = false;

		for (int i = 0; i < userList.size(); i++) {
			if ((userList.get(i).getUserName().equals(userName)) && (userList.get(i).getPassword().equals(passwordU))) {
				vLogin = true;
				break;
			} else {
				vLogin = false;
			}
		}
		return vLogin;
	}

	public String addName() {

		String name = "";
		System.out.println("Please, write your name:");
		name = lector.nextLine();
		return name;
	}

	public String addSurname() {

		String surname = "";
		System.out.println("Please, write your surname:");
		surname = lector.nextLine();
		return surname;
	}

	public String addUserName() {

		String userName = "";
		System.out.println("Please, write your Username:");
		// userName = lector.nextLine().toLowerCase();
		userName = lector.nextLine();
		return userName;
	}

	public String addPassword() {

		String passwordU = "";
		System.out.println("Please, write your password:");
		passwordU = lector.nextLine();
		return passwordU;

	}

	static void showMenuUser(String userName) {

		System.out.println("-----" + userName.toUpperCase() + " MENU VIDEO-----");
		System.out.println("1. Add a new video");
		System.out.println("2. Show videos list");
		System.out.println("3. My data");
		System.out.println("4. Exit");
		System.out.println("SELECT AN OPTION:   ");
	}

	public void videoOptions(UserVideo userS) {

		ServiceVideo videoS = new ServiceVideo();
		videoList = new ArrayList<Video>();
		video = new Video();
		String optionMenu = "";
		int choiceMenu = 0;
		boolean goMenu = false;

		while (!goMenu) {

			showMenuUser(userS.getUserName());

			optionMenu = lector.nextLine();

			if (!validObj.emptyData(optionMenu)) {

				if (validObj.tryNumber(optionMenu)) {

					choiceMenu = Integer.parseInt(optionMenu);

					if (choiceMenu >= 1 || choiceMenu <= 4) {

						switch (choiceMenu) {

						case 1:
							video = videoS.addNewVideo();
							videoList.add(video);
							userS.setVideos(videoList);
							break;
						case 2:
							showUserVideos(userS);
							break;
						case 3:
							showUser(userS);
							break;
						case 4:
							goMenu = true;
							System.out.println("-Finished-");
							break;
						default:
							System.out.println("Type a valid option between 1 and 4. ");
						}
					} else {
						System.out.println("Write a valid option between 1 and 4.");
					}
				} else {
					System.out.println("Write a valid option between 1 and 4.");
					goMenu = false;
				}
			} else {
				goMenu = false;
			}
		}
	}

	static void showUser(UserVideo userS) {
		System.out.println("--- USER " + userS.getUserName().toUpperCase() + " ---");
		System.out.println("Name: " + userS.getName() + " | " + "Surname: " + userS.getSurname() + " | " + " Password: "
				+ userS.getPassword() + " | " + " Registration Date: " + userS.getRegistrationDate());
		System.out.println("");
	}

	static void showUserVideos(UserVideo userS) {

		List<Video> videoList = userS.getVideos();
		List<Tag> tagList = new ArrayList<Tag>();

		try {

			System.out.println("---" + userS.getUserName().toUpperCase() + " VIDEO LIST---");

			for (int i = 0; i < videoList.size(); i++) {
				System.out.println("    - Video " + (i + 1) + " -");
				System.out.println("Title: " + videoList.get(i).getTitle());
				System.out.println("Url: " + videoList.get(i).getUrl());
				tagList = videoList.get(i).getTagList();
				for (int j = 0; j < tagList.size(); j++) {
					System.out.println("Tag " + (j + 1) + ": " + tagList.get(j).getTagTxt());
				}
				System.out.println("");
			}

		} catch (NullPointerException e) {
			System.out.println("You don't have videos yet!");
			System.out.println("");
		}
	}

	public void showUsersList() {

		if (!userList.isEmpty()) {
			System.out.println("--- USERS LIST---");
			Iterator<UserVideo> it = userList.iterator();
			while (it.hasNext()) {
				UserVideo element = it.next();
				System.out.println("Name: " + element.getName().toUpperCase() + " | " + "Surname: "
						+ element.getSurname().toUpperCase() + " | " + "Username: " + element.getUserName() + " | "
						+ " Registration Date: " + element.getRegistrationDate());
			}
		} else {
			System.out.println("No registered users!");
			System.out.println("");
		}
	}

	// lector.close();

}