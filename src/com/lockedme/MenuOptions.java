package com.lockedme;

public class MenuOptions {

	public static void WelcomeScreen(String appName, String developerName) {
		String Details = String.format("\n Welcome to lockedme.com \n" + "\n This application was developed by Namita Jadhav. \n"
				+ "**************** \n" + appName, developerName);
		
		String Function = "You can use this application: \n"
			+ "Retrieve all file names and Add, Delete and Search files in the \"TestMain\" folder \n";
		
		System.out.println(Details);
		System.out.println(Function);
	}

	public static void displayMenu() {
		String MainMenus = "Select option from below and press Enter\n"
		+ "1) Retrieve all files inside \"TestMain\" folder \n" + "2) Display menu for File operations \n"
		+ "3) Exit program \n";
		
		System.out.println(MainMenus);
		}
	
	public static void displayFileMenuOptions() {
		String fileMenus = "\n Select option from below and press Enter \n"
		+ "1) Add a file to \"TestMain\" folder \n" + "2) Delete a file from\"TestMain\" folder \n"
		+ "3) Search for a file from \"TestMain\" folder \n" + "4) Show Previous Menu \n" + "5) Exit program \n";
		
		System.out.println(fileMenus);
		}

}
