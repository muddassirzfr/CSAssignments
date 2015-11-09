 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 6.4
   */

import java.util.*;

// accepts a string and produces vertically and in reverse

public class A64 {

    public static void main (String [] args) {
        System.out.print("Enter a string: " );
        Scanner sc = new Scanner(System.in);
	String word = sc.next();
	System.out.println("\"" + word + "\" reversed and vertical: ");
        System.out.println(verticalReverse(word));
    }

    // Prints a word vertically and in reverse
    // verticalReverse(word to reverse);
    public static String verticalReverse(String str) {
      
	// Initialize a new string
	String result = "";
	
	// Start at length of string - 1. Stop at 0
	for(int i = str.length() - 1; i >= 0; i--) {
	  
	    // Append the character at index i to the string
	    // and the linebreak character
	    result += str.charAt(i) + "\n";
	}
	
	// Return the resulting string
	return result;
    }
}
