package com.skillstorm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

	public static void main(String[] args) throws IOException {
		String filePath = System.getProperty("user.dir");
//		System.out.println(filePath);
		filePath = "./src/com/skillstorm/resources/";
		// Read the contents of Hello.txt and copy it into a file name copy.txt
        
		// Read the contents of words_alpha.txt and 
		String fileName = "words_alpha.txt";
		String outputFileName = "long-words.txt";
		List<String> words = findLongWords(filePath + fileName, filePath + outputFileName, 27);
		for (String word : words) {
			System.out.println(word);
		}
//		System.out.println(words);
		// Write the words that are palindromes to file palindromes.txt
		
	}
	
	////////////////////////////////////////////////////////////
	// Count the occurences of the word "whale" in moby-dick.txt
	/////////////////////////////////////////////////////////////
	
	public static List<String> findLongWords(String file, String outputFile, int numLetters) throws IOException {
		ArrayList<String> longestWords = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
			// TODO Code here
			// version 2
			String line = reader.readLine();
			while (line != null) {
				// check the number of letters
				// if more than numLetters, save to the array
				if (line.length() > numLetters) {
					longestWords.add(line);
					// write to file
					writer.write(line);
					writer.newLine();
				}
//				System.out.println(line);
				line = reader.readLine();
				
			}
			
			return longestWords;
			
			
			// version 5
//			String line = "";
//			do {
//				line = reader.readLine();
//				System.out.println(line); // prints null bc checks condition after print
//			} while (line != null);
			// version 3
//			for (String line = ""; line != null; line = reader.readLine()) {
//				System.out.println(line);
//			}
			// version 4 - different situation where know the number of iterations ahead of time
//			for (int i = 0; i < 10; i++) {
//				System.out.println(reader.readLine());
//			}
			// version 1
//			while((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
		} // Don't need finally block and call to writer.close() and reader.close()
	}
	
	

	
}
