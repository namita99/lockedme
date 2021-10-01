package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileOperations {
	
	public static void createMainFolderIfNotPresent(String folderName) {
		File file = new File(folderName);
		
		// If file doesn't exist, create the main folder
		
		if (!file.exists()) {
			file.mkdirs();
			}
		}
	
	public static void displayAllFiles(String path) {
		FileOperations.createMainFolderIfNotPresent("TestMain");
		// System.out.println("Displaying all files with directory structure in ascending order \n");
		 
		// Display files in ascending order 
		List<String> filesListNames = FileOperations.listFilesInDirectory(path, 0, new ArrayList<String>());
				System.out.println("Displaying all files in ascending order\n");
				Collections.sort(filesListNames);
				filesListNames.stream().forEach(System.out::println);
	}
	
	
	private static List<String> listFilesInDirectory(String path, int count, List<String> FileListNames) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);
		Collections.sort(filesList);
		
		if (files != null && files.length > 0) {
			for (File file : filesList) {
				System.out.print(" ".repeat(count * 2));
				if (file.isDirectory()) {
					
					System.out.println("`-- " + file.getName());
					FileListNames.add(file.getName());
			        listFilesInDirectory(file.getAbsolutePath(), count + 1, FileListNames);
				}
				else {
			        	
			        	System.out.println("|-- " + file.getName());
			            FileListNames.add(file.getName());
			           }
				}
			
			} else {
				System.out.print(" ".repeat(count * 2));
			    System.out.println("Empty Directory");
			}
		 
	      System.out.println();
		  return FileListNames;
		}

	public static void searchFiles(String path, String fileName, List<String> fileListNames) {
	File dir = new File (path);
	File [] files = dir.listFiles();
	List <File> fileList = Arrays.asList(files);
	
	if (files != null && files.length > 0) {
		for(File file : fileList) {
			if(file.getName().startsWith(fileName)) {
				fileListNames.add(file.getAbsolutePath());
			}
			
			if (file.isDirectory()) {
				searchFiles(file.getAbsolutePath(),fileName,fileListNames);
			}
			
		}
	}
}
	
}