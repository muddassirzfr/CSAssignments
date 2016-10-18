 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 6.3
   */

import java.util.*;

// This program accepts a string an indents it by the given number of spaces

public class A63 {

    public static void main (String [] args) {
        System.out.print("Enter a word followed by an integer: ");
        Scanner input = new Scanner(System.in);
	String word = input.next();
	int spaces = input.nextInt();
        System.out.println("\""+ word + "\" indented by " + spaces +
                           " spaces  is:" + indent(word, spaces));
                           
    }

    // Returns a word indented by n spaces.
    // indent(Word to use, number of spaces);
    public static String indent(String word, int spaces) {
      
	// Initialize the string
	String str = "";
	
	// Space number control.
	// Loops the number of spaces specified.
	for(int i = 1; i <= spaces; i++) {
	  
	    // Append a space to the string.
	    str += " ";
	}
	
	// Return the string with the appended word.
	return (str + word);
    }

}
