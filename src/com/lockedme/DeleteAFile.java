package com.lockedme;

import java.io.File;

public class DeleteAFile {
	
public static void deleteFiles(String path) {
		
		File CurrentFile = new File(path);
		File [] files = CurrentFile.listFiles();
		
		if (files != null && files.length > 0) {
			for(File file : files) {
				String fileName = file.getName() + "at" + file.getParent();
				
				if(file.isDirectory()) {
					deleteFiles(file.getAbsolutePath());
				}
				
				if(file.delete()) {
					System.out.println(fileName + "deleted successfully");
					
				}else {
					System.out.println("failed to delete" +fileName);
				}
			}
		}
		
		String currentFileName = CurrentFile.getName() + "at" +CurrentFile.getParent();
		
		if(CurrentFile.delete()) {
			System.out.println(currentFileName + " deleted successfully");
		}else {
			System.out.println("Failed to delete " + currentFileName);
		}
		
		}
}


