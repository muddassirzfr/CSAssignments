 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 2
   *  Due: 2/7/14
   */

//===================================================================
// This class handles the Turtle critter. Turtles will move in a
// clockwise box.
//===================================================================

public class Turtle implements Critter {
 
    private byte moveCount;
    private int[] moveCycle = {SOUTH, WEST, NORTH, EAST};
    private int cycleIndex;
    
    // --------------------------------------------------------------
    // Default Constructor
    // Postcondition: Initializes a new Turtle object
    public Turtle() {
	this.moveCount = 0;
	this.cycleIndex = 0;
    }
    
    // --------------------------------------------------------------
    // Gets the character the Turtle is represented by.
    // Returns: The character 'T'.
    public char getChar() {
	return 'T';
    }
    
    // --------------------------------------------------------------
    // Gets the next move of the Turtle object.
    // Parameter: Critterinfo interface instance
    // Returns: One cardinal direction, following its move cycle
    public int getMove(CritterInfo info) {
	if(moveCount > 3) {
	    this.moveCount = 0;
	    cycleIndex = (cycleIndex + 1) % 4;
	} else {
	    this.moveCount++;
	}
	return moveCycle[cycleIndex];
    }
}