 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 2
   *  Due: 2/7/14
   */

//===================================================================
// This class handles the Mouse critter. Mice will alternate between
// moving north and west.
//===================================================================
 
public class Mouse implements Critter {
    
    public int moveCount;
    
    // --------------------------------------------------------------
    // Default Constructor
    // Postcondition: Initializes a new Mouse object
    public Mouse() {
	this.moveCount = 0;
    }
    
    // --------------------------------------------------------------
    // Gets the character the Mouse is represented by.
    // Returns: The character 'M'.
    public char getChar() {
	return 'M';
    }
    
    // --------------------------------------------------------------
    // Gets the next move of the Mouse object.
    // Parameter: Critterinfo interface instance
    // Returns: One cardinal direction, following its move cycle
    public int getMove(CritterInfo info) {
	this.moveCount++;
	if(moveCount % 2 == 1) {
	    return WEST;
	} else {
	    return NORTH;
	}
    }
}