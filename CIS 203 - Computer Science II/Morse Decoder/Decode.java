/*
 * Name: Tim Backus
 * Course: CIS 203 - Computer Science II
 * Assignment: 10
 * Due: 5/7/14
 */

import java.util.*;
import java.io.*;

//===========================================================================
// This class decodes morse code found in a file and outputs the decoded
// message to a text file.
//===========================================================================

public class Decode {
    
    //-----------------------------------------------------------------------
    // Main method
    // Postcondition: A file, "decoded.txt" will have been created,
    //                containing the decoded message.
    // Throws: FileNotFoundException if the input file isn't found.
    public static void main (String[] args) throws FileNotFoundException {
	Scanner fileScan = new Scanner(new File("coded.txt"));
	PrintStream ps = new PrintStream(new File("decoded.txt"));
	decodeToFile(fileScan, ps);
    }
    
    //-----------------------------------------------------------------------
    // Decodes the message and outputs to a the file.
    // Parameters: fileScan: A Scanner object open on the input file.
    //             ps: A PrintStream object open on the output file.
    // Postcondition: A file containing the decoded message will have been
    //                created.
    private static void decodeToFile(Scanner fileScan, PrintStream ps) {
	while(fileScan.hasNextLine()) {
	    String line = fileScan.nextLine();
	    
	    // Create a list of words, then decode and print them.
	    ArrayList<String> words = getWords(line);
	    for(String s : words) {
		String word = parseWord(s);
		ps.print(word);
	    }
	    ps.println();
	}
    }
    
    //-----------------------------------------------------------------------
    // Separates each line into individual words.
    // Parameters: line: A line of Morse code from the file.
    // Returns: An ArrayList containing the encoded words.
    private static ArrayList<String> getWords(String line) {
	Scanner lineScan = new Scanner(line);
	ArrayList<String> words = new ArrayList<String>();
	
	// Separate a line using whitespace as a delimiter, and add the
	// words to an ArrayList.
	while(lineScan.hasNext())
	    words.add(lineScan.next());
	return words;
    }
    
    //-----------------------------------------------------------------------
    // Splits and decodes a word, letter-by-letter, if it is Morse code.
    // Parameter: word: An encoded word.
    // Returns: A String that is the decoded word, plus any symbols it may
    //          have with it.
    private static String parseWord(String word) {
	String result = "";
	
	// Split the word into a String array, using '|' as a delimiter.
	String[] codes = word.split("\\|");
	
	// If the words are Morse code, decode them. If not, just add
	// the character that is found.
	for(int i = 0; i < codes.length; i++) {
	    if(isMorseCode(codes[i]))
		result += MorseCode.getLetter(codes[i]);
	    else
		result += codes[i];
	}
	return result + " ";
    }
   
    //-----------------------------------------------------------------------
    // Checks if a token is Morse code.
    // Parameter: code: A String that the user wants to check.
    // Precondition: The passed String must not contain any delimiters.
    // Returns: True if no other characters were found besides '.' and '-'.
    private static boolean isMorseCode(String code) {
	for(int i = 0; i < code.length(); i++) {
	    if(code.charAt(i) < '-' || code.charAt(i) > '.' )
		return false;
	}
	return true;
    }
}