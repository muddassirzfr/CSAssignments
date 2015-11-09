 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 2
   *  Due: 2/7/14
   */

//===================================================================
// This class handles a Bird critter. Birds will move a random
// direction every turn.
//===================================================================
 
import java.util.Random;

public class Bird implements Critter {

    // --------------------------------------------------------------
    // Gets the character the Bird is represented by.
    // Returns: The character 'B'.
    public char getChar() {
	return 'B';
    }
    
    // --------------------------------------------------------------
    // Gets the next move of the Bird object.
    // Parameter: Critterinfo interface instance
    // Returns: One random cardinal direction
    public int getMove(CritterInfo info) {
	Random rand = new Random();
	int dir = rand.nextInt(4);
	if (dir == 0) {
	    return NORTH;
	} else if (dir == 1) {
	    return SOUTH;
	} else if (dir == 2) {
	    return EAST;
	} else if (dir == 3) {
	    return WEST;
	} else {
	    System.out.println("Move error in Bird class. dir=" + dir);
	    return CENTER;
	}
    }
}