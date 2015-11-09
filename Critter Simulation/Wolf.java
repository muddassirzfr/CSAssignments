 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 2
   *  Due: 2/7/14
   */

//===================================================================
// This class handles the Wolf critter. Wolves can take on one of
// four unique behaviors:
//-------------------------------------------------------------------
// 0: Groggy: Moves slowly
// 1: Defender: Defends its territory
// 2: Skittish: Avoids other critters
// 3: Sweeper: Prowls the map
//===================================================================
 
import java.util.Random;

public class Wolf implements Critter {
    
    private int moveCount = 0;
    private int behaviorNumber = 0;
    private int xOffset = 0;
    private int yOffset = 0;
    
    // --------------------------------------------------------------
    // Default Constructor
    // Postcondition: Initializes a new Wolf object with a weighted
    //                randomly chosen behavior.
    public Wolf () {
	Random randObj = new Random();
	this.behaviorNumber = getBehavior();
    }
    
//===================================================================
// Accessors
//===================================================================
    
    // --------------------------------------------------------------
    // Gets the character the Wolf is represented by.
    // Returns: A circle with the behavior number inside.
    public char getChar() {
	// Groggy
	if(this.behaviorNumber == 0)
	    return '\u0259';
	// Defender
	else if (this.behaviorNumber == 1)
	    return '\u1ff6';
	// Skittish
	else if (this.behaviorNumber == 2)
	    return '\u017a';
	// Sweeper
	else if (this.behaviorNumber == 3)
	    return '\u00a5';
	else
	// Fallback
	    return 'W';
    }
    
    // --------------------------------------------------------------
    // Gets the next move of the Wolf object.
    // Parameter: Critterinfo interface instance
    // Returns: One cardinal direction based on the behavior
    public int getMove(CritterInfo info) {
	this.moveCount++;
	if(this.behaviorNumber == 0)
	    return moveTypeGroggy();
	else if(this.behaviorNumber == 1)
	    return moveTypeDefend(info);
	else if(this.behaviorNumber == 2)
	    return moveTypeSkittish(info);
	else if(this.behaviorNumber == 3)
	    return moveTypeSweep();
	else
	    return CENTER;
    }
    
//===================================================================
// Personality AIs
//===================================================================

    
    // --------------------------------------------------------------
    // Chooses one random cardinal direction every 5 moves.
    // Returns: One random direction if the move count is divisible
    // 	        by 5.
    private int moveTypeGroggy() {
	if(this.moveCount % 5 == 0)
	    return getRandomDirection();
	else
	    return CENTER;
    }
    
    // --------------------------------------------------------------
    // Doesn't move if there are no critters in an adjacent spot, but
    // will chase a critter it finds up to 3 spaces from its original
    // spawn point. The wolf returns to its original spot when the
    // chased critter gets out of range.
    //---------------------------------------------------------------
    // Parameter: Critterinfo interface instance
    // Returns: CENTER if there are no adjacent critters, and will
    //          return the respective direction to chase a critter
    //          and move back when needed.
    private int moveTypeDefend(CritterInfo info) {
	
	// Get adjacent critters and chase them
	if(info.getNeighbor(NORTH) != '.' && Math.abs(this.yOffset) < 3) {
	    this.yOffset++;
	    return NORTH;
	} else if(info.getNeighbor(SOUTH) != '.' && 
		  Math.abs(this.yOffset) < 3) {
	    this.yOffset--;
	    return SOUTH;
	} else if(info.getNeighbor(EAST) != '.' && 
		  Math.abs(this.xOffset) < 3) {
	    this.xOffset++;
	    return EAST;
	} else if(info.getNeighbor(WEST) != '.' && 
		  Math.abs(this.xOffset) < 3) {
	    this.xOffset--;
	    return WEST;
	
	// If no critters are adjacent, return to the spawn point
	} else {
	    if(this.yOffset > 0) {
		this.yOffset--;
		return SOUTH;
	    }
	    else if (this.yOffset < 0) {
		this.yOffset++;
		return NORTH;
	    }
	    else if (this.xOffset > 0) {
		this.xOffset--;
		return WEST;
	    }
	    else if (this.xOffset < 0) {
		this.xOffset++;
		return EAST;
	    }
	    else
		return CENTER;
	}
    }
    
    // --------------------------------------------------------------
    // Attempts to choose a safe direction that another critter is
    // not occupying. Will also check the "safe" spot is occupied,
    // and will choose another direction if so. If no critters are
    // adjacent, it will choose a random direction.
    //---------------------------------------------------------------
    // Parameter: Critterinfo interface instance
    // Returns: A seemingly safe direction to move.
    private int moveTypeSkittish(CritterInfo info) {
	if(info.getNeighbor(NORTH) != '.') {
	    if(info.getNeighbor(SOUTH) != '.')
		return EAST;
	    return SOUTH;
	}
	else if(info.getNeighbor(EAST) != '.') {
	    if(info.getNeighbor(WEST) != '.')
		return NORTH;
	    return WEST;
	}
	else if(info.getNeighbor(SOUTH) != '.') {
	    if(info.getNeighbor(NORTH) != '.')
		return WEST;
	    return NORTH;
	}
	else if(info.getNeighbor(WEST) != '.') {
	    if(info.getNeighbor(EAST) != '.')
		return SOUTH;
	    return EAST;
	}
	else
	    return getRandomDirection();
    }
    
    // --------------------------------------------------------------
    // Proceeds in a cycle of Up 1x, Left 7x, Up 1x, Right 5x.
    // Returns: One direction based on its current move cycle.
    private int moveTypeSweep(){
	
	// Reset the move counter if it's at the max
	if(this.moveCount == 14)
	    this.moveCount = 0;
	if(this.moveCount == 0 || this.moveCount == 8)
	    return NORTH;
	else if(this.moveCount >= 1 && this.moveCount <= 7) {
	    return WEST;
	}
	else if(this.moveCount >= 9 && this.moveCount <= 13) {
	    return EAST;
	}
	
	// Fallback
	else {
	    return CENTER;
	}
    }
    
//===================================================================
// Helper Methods
//===================================================================
    
    // --------------------------------------------------------------
    // Weights the chances of a Groggy Wolf to be more rare.
    // Returns: an integer representing the behavior number.
    private int getBehavior() {
	Random randObj = new Random();
	int rand = randObj.nextInt(100) + 1;
	
	// 15% chance to initialize a groggy wolf
	if(rand >= 15 && rand <= 100) {
	    return (randObj.nextInt(3) + 1);
	} else {
	    return 0;
	}
    }
    
    // --------------------------------------------------------------
    // Chooses one random cardinal direction.
    // Returns: An integer representing a direction.
    private int getRandomDirection() {
	Random randObj = new Random();
	int rand = randObj.nextInt();
	if(rand % 4 == 0)
	    return NORTH;
	else if (rand % 4 == 1)
	    return EAST;
	else if (rand % 4 == 2)
	    return SOUTH;
	else
	    return WEST;
    }
}