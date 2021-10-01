package com.lockedme;

public class LockedMeWelcome {

	public static void main(String[] args) {
		
		FileOperations.createMainFolderIfNotPresent("TestMain");
		MenuOptions.WelcomeScreen("LockedMe", "Namita");
		HandleAFile.WelcomeScreenInput();

	}

}
