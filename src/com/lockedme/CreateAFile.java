package com.lockedme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateAFile {

	public static void  createFile(String fileToAdd,Scanner sc) {
		
		FileOperations.createMainFolderIfNotPresent("TestMain");
		Path path = Paths.get("./TestMain/" + fileToAdd);
		
		try {
			Files.createDirectories(path.getParent());
			Files.createFile(path);
			System.out.println(fileToAdd + " created successfully");
			System.out.println("Would you like to add some content to the file? Y/N)");
			
			String ch2 = sc.next();
			sc.nextLine();
			if (ch2.equals("y")) {
			System.out.println("\n Input content and press enter\n");
			String content = sc.nextLine();
			Files.write(path, content.getBytes());
			
			System.out.println("Content written to file " + fileToAdd);
			System.out.println("Content can be read using Notepad");
			}
			}catch (IOException e) {
				
				System.out.println("Failed to create file " + fileToAdd);
				System.out.println(e.getClass().getName());
				}
		}


public static List<String> displayFileLocations(String fileName, String path) {
	List<String> ListNames = new ArrayList<>();
	FileOperations.searchFiles(path, fileName, ListNames);
	
	if(ListNames.isEmpty()) {
		System.out.println("Couldn't find any file with given file name " + fileName + "\n");
		} else {
				System.out.println("\n Found file at below location:");
				List<String> files = IntStream.range(0, ListNames.size()).mapToObj(index ->(index+1)
						+ ListNames.get(index)).collect(Collectors.toList());
				files.forEach(System.out::println);
				}
	
	
	return ListNames;
	}


}
