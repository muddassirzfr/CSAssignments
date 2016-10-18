/*
 * Timothy Backus
 * Computer Science I
 * Section 001
 * Assignment 4
*/ 

// This program draws a scaleable pattern
public class Pattern {
  
    // Global constant for adjusting pattern scale
    public static final int SCALE = 4;
  
    // Main method
    public static void main (String[] args) {
      
	// I could add a section here for program arguments since
	// it would be easier to check the scale.
	// if (args.length == 1) {
	// 	SCALE = Integer.parseInt(args[0]);
	// }
	// Assuming SCALE wasn't final.
	
      
	drawHLine();
	drawPeak();
	drawInvPeak();
	drawHLine();
	drawInvPeak();
	drawPeak();
	drawHLine();
    }
    
    // Draw a horizontal line with +'s on both sides
    public static void drawHLine() {
      
	System.out.print("+");
	
	// Draw 2 x SCALE - 1 hyphens
	for (int i = 1; i <= (2 * SCALE - 1); i++) {
	      System.out.print("-");
	}
	
	System.out.print("+");
	
	// End the line
	System.out.println();
    }
    
    // Draws the peak-shaped component
    public static void drawPeak() {
      
	// For each line, while the iteration is <= the SCALE.
	for (int lines = 1; lines <= SCALE; lines++) {
	  
	    System.out.print("|");
	    
	    // Print x spaces, decrementing with each iteration
	    // and starting at SCALE - 1
	    for (int j = (SCALE - 1); j >= lines; j--) {
		  System.out.print(" ");
	    }
	    
	    // Print x slashes, incrementing with each iteration
	    // and starting at 1
	    for (int j = 1; j <= (lines - 1); j++) {
		  System.out.print("/");
	    }
	    
	    System.out.print("*");
	    
	    // Print x slashes, incrementing with each iteration
	    // and starting at 1
	    for (int j = 1; j <= (lines - 1); j++) {
		  System.out.print("\\");
	    }
	    
	    // Print x spaces, decrementing with each iteration
	    // and starting at SCALE - 1
	    for (int j = (SCALE - 1); j >= lines; j--) {
		  System.out.print(" ");
	    }
	    
	    System.out.print("|");
	    
	    // Break the line
	    System.out.println();
	}
    }
    
    // Draw the same figure as drawPeak(), but mirrored
    // along the X axis.
    public static void drawInvPeak() {
      
	// For each line, while the iteration is <= the SCALE.
	for (int lines = 1; lines <= SCALE; lines++) {
	  
	    System.out.print("|");
	    
	    // Print x spaces, incrementing with each iteration
	    // and starting at 1
	    for (int j = 1; j <= (lines - 1); j++) {
		  System.out.print(" ");
	    }
	    
	    // Print x backslashes, decrementing with each iteration
	    // and starting at SCALE - 1
	    for (int j = (SCALE - 1); j >= lines; j--) {
		  System.out.print("\\");
	    }
	    
	    System.out.print("*");
	    
	    // Print x backslashes, decrementing with each iteration
	    // and starting at SCALE - 1
	    for (int j = (SCALE - 1); j >= lines; j--) {
		  System.out.print("/");
	    }
	    
	    // Print x spaces, incrementing with each iteration
	    // and starting at 1
	    for (int j = 1; j <= (lines - 1); j++) {
		  System.out.print(" ");
	    }
	    
	    System.out.print("|");
	    
	    // Break the line
	    System.out.println();
	}
    }
}