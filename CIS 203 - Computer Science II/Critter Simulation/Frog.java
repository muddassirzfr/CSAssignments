 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 2
   *  Due: 2/7/14
   */

//===================================================================
// This class handles the Frog critter. Frogs will move three times
// in one direction, and then choose a new random direction.
//===================================================================
 
import java.util.Random;

public class Frog implements Critter {

    private byte moveCount;
    private int lastMove;
    
    // --------------------------------------------------------------
    // Default Constructor
    // Postcondition: Initializes a new Frog object
    public Frog() {
	this.moveCount = 0;
	this.lastMove = newDirection();
    }
    
    // --------------------------------------------------------------
    // Gets the character the Frog is represented by.
    // Returns: The character 'F'.
    public char getChar() {
	return 'F';
    }
    
    // --------------------------------------------------------------
    // Gets the next move of the Frog object.
    // Parameter: Critterinfo interface instance
    // Returns: One cardinal direction, following its move cycle
    public int getMove(CritterInfo info) {
	if(moveCount > 3) {
	    this.moveCount = 0;
	    this.lastMove = newDirection();
	} else {
	    this.moveCount++;
	}
	return lastMove;
    }
    
    // --------------------------------------------------------------
    // Gets a new random move driction
    // Returns: One random cardinal direction
    private int newDirection() {
	Random rand = new Random();
	int r = rand.nextInt(4);
	if(r == 0) {
	    return NORTH;
	} else if(r == 1) {
	    return SOUTH;
	} else if(r == 2) {
	    return EAST;
	} else if(r == 3) {
	    return WEST;
	} else {
	    System.out.println("FROG ERROR. r= " + r);
	    return CENTER;
	}
    }
}