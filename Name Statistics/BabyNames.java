 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 10
   */

import java.io.*;
import java.util.Scanner;

public class BabyNames {
    
    // Main method. Throws an exception if the file cannot be found
    public static void main(String[] args) throws FileNotFoundException {
	
	// Valid name flag
	boolean valid = false;
	
	// Initialize a new scanner to handle user input
	Scanner input = new Scanner(System.in);
	
	// Initialize a new file handle
	File f = new File("names.txt");
	
	// Initialize a new file scanner
	Scanner fStream = new Scanner(f);
	
	// Print the program information
	printInfo();
	
	// Loop until the user
	while(!valid) {
	    
	    // Set checkName to the specified name, with correct capitalization
	    String checkName = getNormalizedName(input, "Type a name: ");

	    // Only process the name if the user enters a name containing
	    // only letters
	    if(isValidName(checkName)) {
		
		// Set the flag to true
		valid = true;
		
		// Print statitsics header
		System.out.println("Statistics on name \"" + checkName + "\"");
		
		// Search the file for the normalized name and processes
		// the subsequent data in the file, if the name is listed
		parseLine(fStream, checkName);
	    } else {
		System.out.println("Please type a valid name (only letters).");
	    }
	}
    }
    
    //-----------------------------------------------------------------------
    // Checks if the name entered only contains letters
    // isValidName(Name to check)
    //-----------------------------------------------------------------------
    
    public static boolean isValidName(String name) {
	
	// Convert name to all lowercase
	String s = name.toLowerCase();
	
	// For all char indexes in the name,
	for (int i = 0; i <= s.length() - 1; i++) {
	    
	    // Check if the character is not a letter
	    if(s.charAt(i) < 'a' || s.charAt(i) > 'z')
		return false;
	}
	
	// Return true if all characters have been processed
	return true;
    }
    
    //-----------------------------------------------------------------------
    // Finds the line in the file with the specified name, and processes
    // the data on the same line
    // parseLine(File scanner, name to check)
    //-----------------------------------------------------------------------
    
    public static void parseLine(Scanner fs, String name) {
	
	// Flag whether or not the name is found in the list
	boolean found = false;
	
	// Loop while the scanner can continue and the name hasn't been found
	while(fs.hasNext() && !found) {
	    
	    // Set readName to the next whitespace-delimited token
	    String readName = fs.next();
	    
	    // If it's equal to the specified name,
	    if(readName.equals(name)) {
		
		// Set the found flag to true
		found = true;
		
		// Send the line containing the name to splitCounts
		splitCounts(fs.nextLine());
	    }
	}
	
	// If the end of file is reached without setting the found flag,
	if(!found) {
	    
	    // Notify the user
	    System.out.println("\""+ name + "\" not found.");
	}
    }
    
    //-----------------------------------------------------------------------
    // Splits and outputs the trailing integers in the passed line
    // parseLine(Line to split)
    //-----------------------------------------------------------------------
    
    public static void splitCounts(String line) {
	
	// Remove trailing whitespace from the passed line
	String s = line.trim();
	
	// Initialize a new scanner to handle the passed line
	Scanner sc = new Scanner(s);
	
	// Initialize a new integer array of size 11
	int[] arrayCount = new int[11];
	
	// For each index in the int array, and while the scanner can
	// continue finding integers,
	for(int i = 0; i <= 10 && sc.hasNextInt(); i++) {
	    
	    // Set index i of the array to the read integer
	    arrayCount[i] = sc.nextInt();
	    
	    // Print the decade followed by arrayCount's index i
	    System.out.println((1900 + 10 * i) + ": " + arrayCount[i]);
	}
    }
    
    //-----------------------------------------------------------------------
    // Returns a corrected version of the entered name (first letter is
    // capitalized, following letters are lowercase)
    // getNormalizedName(User input scanner, Message to print)
    //-----------------------------------------------------------------------
    
    public static String getNormalizedName(Scanner sc, String prompt) {
	
	// Print the message
	System.out.print(prompt);
	
	// Set the user's first word typed to a string
	String s = sc.next();
	
	// Get the first letter of the entered string
	String firstLetter = s.substring(0, 1);
	
	// Get the subsequent letters after the first
	String ssLetters = s.substring(1);
	
	// Return the normalized name
	return firstLetter.toUpperCase() + ssLetters.toLowerCase();
    }
    
    //-----------------------------------------------------------------------
    // Prints the information about this program
    // printInfo()
    //-----------------------------------------------------------------------
    
    public static void printInfo() {
	System.out.println("This program graphs the popularity of a name");
	System.out.println("in Social Security baby name statistics");
	System.out.println("recorded since the year 1900.");
    }
}