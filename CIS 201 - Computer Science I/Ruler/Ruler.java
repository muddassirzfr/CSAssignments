//=============================================================
// Timothy Backus
//-------------------------------------------------------------
// Assignment 5 - Ruler
// Computer Science I
// Section 001
//=============================================================

// The scanner library must be imported to be used
import java.util.Scanner;

// This class draws a ruler of x inches, where x is the value specified
// by the user. While technically scaleable to 99 inches, the terminal
// on Linux computers wraps the text. Eclipse's console renders the 
// ruler correctly.
public class Ruler {
  
	//=====================================================
	// Main method
	//=====================================================

    public static void main (String[] args) {
    	
    	// Initialize a new instance of the Scanner object
    	// to the variable 'input'.
	Scanner input = new Scanner(System.in);
    	
    	// Print the question to the screen
    	System.out.print("How many inches long will the ruler be? ");
    	
    	// Call the drawRuler() method with the user's input as the
    	// argument. There is no need to initialize a new variable.
    	drawRuler(input.nextInt());
	
	// Break the line
	System.out.println();
    }
    
    //-----------------------------------------------------
    // This method draws the ruler
    //-----------------------------------------------------
    
    // drawRuler(int <inches to draw>);
    public static void drawRuler(int inches) {
    	
    	// Print a whitespace
    	System.out.print(" ");
    	
    	// Draw the various horizontal segments of the ruler
    	// with the passed value
    	drawTop(inches);
    	drawMid(inches);
    	System.out.print("|");
    	drawBottom(inches);
    }
    
    //-----------------------------------------------------
    // This method draws the top line of the ruler
    //-----------------------------------------------------
    
    public static void drawTop(int size) {
    	
    	// Loop <inches x 4 + 1> times
    	for (int i = 1; i <= (size * 4 + 1); i++) {
    		
	    // Print underscores
	    System.out.print("_");
    	}
    	
    	// Break the line
    	System.out.println();
    }
    
    //-----------------------------------------------------
    // This method draws the middle line of the ruler
    //-----------------------------------------------------
    
    public static void drawMid(int size) {
    	
    	// Loop <inches x 2 + 1> times, since we are
    	// drawing two characters at once
    	for (int i = 1; i <= 2 * size + 1; i++) {
	  
	    // Print a pipe and tick
	    System.out.print("|`");
    	}
    	
    	// Print a pipe and break the line
    	System.out.println("|");
    }
    
    //-----------------------------------------------------
    // This method draws the bottom of the ruler
    //-----------------------------------------------------
    
    public static void drawBottom(int size) {
    	
    	// Loop <inches> times
    	for (int i = 1; i <= size; i++) {

	    // Print two underscores since we will
	    // always be printing two before a number
	    System.out.print("__");
	    
	    // Since we couldn't use a conditional test,
	    // i / 10 will give us 0 for numbers 1 - 9,
	    // and will be 1 or greater for anything higher,
	    // assuming j is initialized at 0.
	    for (int j = 0; j == i / 10; j++) {
		    
		// Print an extra underscore if we have a
		// one-digit number
		System.out.print("_");
	    }
	    
	    // Print the current number
	    System.out.print(i);
    	}
    	
    	// Print an underscore and pipe to end the ruler,
    	// and break the line
    	System.out.println("_|");
    }
}