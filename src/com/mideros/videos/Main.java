package com.mideros.videos;

import java.util.Scanner;

/**
 * Exercici Domini Videos.
 * Crea un programa en Java amb l’estructura de domini de les classes:
 * Video: esta format por una URL, un títol i una llista de tags*.
 * Usuari: esta format per un nom, cognom, password i una data de registre.
 * Un usuari pot crear nous vídeos i veure un llistat dels seus videos.
 * Un tag es un text amb una paraula, tenir en compte que un video pot tenir varis tags.
 * La estructura no ha de permetre afegir camps buits, en cas de que n’hi hagi ha de retornar una excepció.
 * 
 * @author Yohanna Mideros G.
 * @version 1.0
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);
		ServiceUser userV = new ServiceUser();
		DataValidation validObj= new DataValidation();
		String option = "";
		int choice = 0;
		boolean go = false;

		while (!go) {

			showMenu();
			

			option = lector.nextLine();

			if (!validObj.emptyData(option)) {

				if (validObj.tryNumber(option)) {

					choice = Integer.parseInt(option);

					if (choice >= 1 || choice <= 4) {

						switch (choice) {

						case 1:
							userV.registerUser();							
							break;
						case 2:
							userV.loginUser();							
							break;
						case 3:	
							userV.showUsersList();
							break;
						case 4:							
							go = true;
							System.out.println("Exercise ended");
							break;
						default:
							System.out.println("Type a valid option between 1 and 4. ");
						}
					} else {
						System.out.println("Write a valid option between 1 and 4");
					}
				} else {
					System.out.println("Write a valid option between 1 and 4");
					go = false;
				}
			} else {
				go = false;
			}
		}
		lector.close();
	}

	public static void showMenu() {

		System.out.println("-----VIDEOS-----");
		System.out.println("1. User Register");
		System.out.println("2. User Login");
		System.out.println("3. Show Users");
		System.out.println("4. Exit");
		System.out.println("CHOOSE AN OPTION:  ");
	}
}