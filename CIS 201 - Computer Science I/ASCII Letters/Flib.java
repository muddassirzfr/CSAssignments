/* Name: Timothy Backus
 CIS 201 - Computer Science I
 Section 001
 Assignment 2
*/

// This program prints "GIGGLING FLIBBERTIGIBBET" in ASCII art.

public class Flib {
  
    // Main method
    public static void main(String[] args) {
	drawWord1();
	drawWord2();
    }
    
    
    //---------------------------------------------
    // This section draws each word
    //---------------------------------------------
    
    // Draw the word 'GIGGLING' using the letters
    public static void drawWord1() {
	drawG();
	drawI();
	drawG();
	drawG();
	drawL();
	drawI();
	drawN();
	drawG();
	
	// Print out 2 + 1 blank lines
	// (A line break is already inserted at the start of
	// each letter).
	System.out.println("\n\n");
    }
    
    public static void drawWord2() {
      drawF();
      drawL();
      drawI();
      drawB();
      drawB();
      drawE();
      drawR();
      drawT();
      drawI();
      drawG();
      drawI();	
      drawB();
      drawB();
      drawE();
      drawT();
    }
    
    
    //---------------------------------------------
    // This section draws each letter
    //---------------------------------------------
    
    // Draw a 'G' using the components
    public static void drawG() {
	System.out.println();
	topGBR();
	System.out.println("$");
	System.out.println("$  $$");
	botGB();
    }
    
    // Draw a 'I' using the components
    public static void drawI() {
	System.out.println();
	topTI();
	System.out.println("$$$$$");
    }
    
    // Draw a 'L' using the components
    public static void drawL() {
	System.out.println();
	leftLine();
	botLE();
    }
    
    // Draw a 'N' (no efficient way to break up)
    public static void drawN() {
	System.out.println();
	System.out.println("$    $");
	System.out.println("$$   $");
	System.out.println("$ $  $");
	System.out.println("$  $ $");
	System.out.println("$   $$");
	System.out.println("$    $");
    }
    
    // Draw a 'F' using the components
    public static void drawF() {
	System.out.println();
	topFE();
	leftLine();
    }
    
    // Draw a 'B' using the components
    public static void drawB() {
	System.out.println();
	topGBR();
	topGBR();
	botGB();
    }
    
    // Draw a 'E' using the components
    public static void drawE() {
	System.out.println();
	topFE();
	botLE();
    }
    
    // Draw a 'R' using the components
    public static void drawR() {
	System.out.println();
	topGBR();
	topGBR();
	System.out.println("$   $");
	System.out.println("$   $");
    }
    
    // Draw a 'T' using the components
    public static void drawT() {
	System.out.println();
	topTI();
	System.out.println("  $");
    }
    
    
    //---------------------------------------------
    // This section draws the individual components
    //---------------------------------------------
    
    // Draw the top of the letters G, B, and R
    // Also handles the middle of B and R
    public static void topGBR() {
	System.out.println("$$$$");
	System.out.println("$   $");
    }
    
    // Draw the bottom of the letters G and B
    public static void botGB() {
	System.out.println("$   $");
	System.out.println("$$$$");
    }
    
    // Draw the top of the letters T and I
    public static void topTI() {
	System.out.println("$$$$$");
	System.out.println("  $");
	System.out.println("  $");
	System.out.println("  $");
	System.out.println("  $");
	
    }
    
    // Draw a left-aligned, vertical line of 3 lines
    public static void leftLine() {
	System.out.println("$");
	System.out.println("$");
	System.out.println("$");
    }
    
    // Draw the bottom of the letters L and E
    public static void botLE() {
	System.out.println("$");
	System.out.println("$");
	System.out.println("$$$$$");
    }
    
    // Draw the top of the letters F and E
    public static void topFE() {
	System.out.println("$$$$$");
	System.out.println("$");
	System.out.println("$$$$");
    }
    
}
