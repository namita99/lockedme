package com.lockedme;

import java.util.*;

public class HandleAFile {

	public static void WelcomeScreenInput() {
		
		    boolean b1 = true;
			Scanner sc = new Scanner(System.in);
			do {
			try {
				
			MenuOptions.displayMenu();
			int ch = sc.nextInt();
			switch (ch) {
			
			case 1:
			FileOperations.displayAllFiles("TestMain");
			break;
			
			case 2:
			HandleAFile.handleFileMenuOptions();
			break;
			
			case 3:
			System.out.println("Program existed successfully");
			b1 = false;
			sc.close();
			System.exit(0);
			break;
			
			default:
			System.out.println("Please select a valid option from above");
			}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				WelcomeScreenInput();
			}
		
		} while (b1 == true);
		
	}

	private static void handleFileMenuOptions() {
		boolean b2 = true;
		Scanner sc = new Scanner(System.in);
		do {
		try {
			
		MenuOptions.displayFileMenuOptions();
		FileOperations.createMainFolderIfNotPresent("TestMain");
		int ch1 = sc.nextInt();
		
		switch (ch1) {
		case 1:
			// Add a File
			
			System.out.println("Enter the name of the file to be added to the \"TestMain\" folder");
			String AddFile = sc.next();
			CreateAFile.createFile(AddFile, sc);
			break;
			
		case 2:
			// File/Folder delete
			
			System.out.println("Enter the name of the file to be deleted from \"TestMain\" folder");
			String DeleteFile = sc.next();
			FileOperations.createMainFolderIfNotPresent("TestMain");
			
			List<String> filesToDelete = CreateAFile.displayFileLocations(DeleteFile, "TestMain");
			String deletePrompt = "Select index of which file to  delete"
			+ "\n Enter 0 if you want to delete all elements";
			
			System.out.println(deletePrompt);
			int i = sc.nextInt();
			
			if (i != 0) {
				DeleteAFile.deleteFiles(filesToDelete.get(i - 1));
				} else {
					
			// If i == 0, delete all files displayed for the name
			            for (String path : filesToDelete) {
			            	DeleteAFile.deleteFiles(path);
			             }
			            }
			break;
			
		case 3:
			// File/Folder Search
			
			System.out.println("Enter the name of the file to be searched from \"TestMain\" folder");
			String fileName = sc.next();
			FileOperations.createMainFolderIfNotPresent("TestMain");
			CreateAFile.displayFileLocations(fileName, "TestMain");
			break;
			
		case 4:
			// Go to Previous menu
			return;
			
		case 5:
			// Exit
			
			System.out.println("Program existed successfully");
			b2 = false;
			sc.close();
			System.exit(0);
			
		default:
			
			System.out.println("Please select a valid option from above");
			}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
			    handleFileMenuOptions();
			    }
		} while (b2 == true);
		}
}
