//=============================================================
// Timothy Backus
//-------------------------------------------------------------
// Assignment 4 - Seattle Space Needle (Extra Credit)
// Computer Science I
// Section 001
//=============================================================

// This program draws a scaleable Seattle Space Needle in ASCII art.
public class Pattern {
  
    
/*   
     I think it'd be more convenient to remove the final modifier
     from SCALE, still keep it global, and put this in the main
     method, as the scale can be changed at runtime with 
     "java Pattern <INSERT SCALE HERE>"
    
     // Check if there's only one argument
     if (args.length == 1) {
    
     		// Set scale to an integer passed at runtime
     		// from the args string array at index 0
     		scale = Integer.parseInt(args[0]);
     }
    
     // If there's not only one argument
     else {
    
    		// Set the scale to a default value
    		scale = 3; // default
    }
    
    I just don't know if we'd get marked off for that.
*/

    // Global constant for figure scale
    public static final int SCALE = 4;
    
    //=======================================
    // Main Method
    //=======================================
    
    public static void main(String[] args) {
    	
    	// Draw each component of the Space Needle
    	drawNeedle();
	drawDeck();
	drawNeedle();
	drawBody();
    }
    
    //=======================================
    // This section draws larger components
    //=======================================
    
    // Draws the observation deck
    public static void drawDeck() {
    	drawDomeTop();
	drawDeckMid();
	drawDomeBottom();
    }
    
    // Draws the body of the tower
    public static void drawBody() {
    	drawTower();
    	drawDomeTop();
	drawDeckMid();
    }
    
    
    //=======================================
    // This section draws smaller components
    // that make up the larger ones
    //=======================================
    
    //---------------------------------------
    // Draws two pipes, centered
    //---------------------------------------
    
    public static void drawNeedle() {
	      
    	// Line control loop
	for (int i = 1; i <= SCALE; i++) {
	      
	    // Spaces to the left of the tip
	    for (int j = 1; j <= SCALE * 3; j++) {
		System.out.print(" ");
	    }
	    
	    // Draw the two pipes for the tip and break the line
	    // Spaces to the right are useless
	    System.out.println("||");
	}
    }
    
    //---------------------------------------
    // Draws the top of a dome
    //---------------------------------------
    
    public static void drawDomeTop() {
      
    	// Line control loop
	for (int i = 1; i <= SCALE; i++) {
	    
	    // Print spaces
		for (int j = 3 * SCALE - 3 - 3 * (i - 1); j >= 1; j--) {
		System.out.print(" ");
	    }
	    
	    // Print "__/"
	    System.out.print("__/");
	    
	    // Print colons
	    for (int j = 1; j <= 3 * (i - 1); j++) {
		System.out.print(":");
	    }
	    
	    // Print "||"
	    System.out.print("||");
	    
	    // Print colons
	    for (int j = 1; j <= 3 * (i - 1); j++) {
		System.out.print(":");
	    }
	    
	    // Print "\__"
	    System.out.print("\\__");
	    
	    // Break the line
	    System.out.println();
	}
	
		
    }
    
    //---------------------------------------
    // Draws the middle of a dome, which also
    // doubles as the bottom of the tower
    //---------------------------------------
    
    public static void drawDeckMid() {
    	
    	System.out.print("|");
    	
    	// Draw "s
    	for (int i = 1; i <= SCALE * 6; i++) {
    		System.out.print("\"");
    	}
    	
    	System.out.println("|");
    }
    
    //---------------------------------------
    // Draws the bottom of a dome
    //---------------------------------------
    
    public static void drawDomeBottom() {
    	
    	// Line control loop
    	for (int i = SCALE; i >= 1; i--) {
    		
	    // Wouldn't it be faster to use a bitwise left
	    // shift for SCALE * 2 since it's a power of 2?
	    // (Change "SCALE * 2" to "SCALE << 1"?)
	    
	    // Print spaces
	    for (int j = i * 2 - 2; j <= SCALE * 2 - 3; j++) {
		    System.out.print(" ");
	    }
	    
	    // Draw /\
	    System.out.print("\\_");
	    
	    // Print /\'s
	    for (int j = 2 * i + (SCALE - 1); j >= 1; j--) {
		    System.out.print("/\\");
	    }
	    
	    System.out.println("_/");
    	}
    	
    }
    
    //---------------------------------------
    // Draws the thicker part of the tower
    // body
    //---------------------------------------
    
    public static void drawTower() {
    	
    	// Line control loop
    	for (int i = 1; i <= (SCALE * 4); i++) {
	    
	    // Draws spaces
	    for (int j = 1; j <= SCALE * 3 - 3; j++) {
		    System.out.print(" ");
	    }
	    
	    // Draw tower body segment
	    System.out.println("|%%||%%|");
    	}
    }
    
}