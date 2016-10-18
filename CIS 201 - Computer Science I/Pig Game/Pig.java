 /**
   *  Name: Timothy Backus
   *  Course: CIS 201 - Computer Science I
   *  Section: 001
   *  Assignment: 9
   */

import java.util.*;

//===========================================================================
// This game is played with two players, alternating turns. On the players'
// respective turns, they will roll a six-sided die an infinite number of
// times and accumulate points. However, if a 1 is rolled, they will not
// gain any points for their turn. A player may choose to stop rolling at
// any time during their turn. A player wins when their score reaches 100.
//===========================================================================

public class Pig {
    
    //-----------------------------------------------------------------------
    // Main Method
    //-----------------------------------------------------------------------
    
    public static void main (String[] args) {
	
	// Initialize a new Scanner and Random object
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	
	// Start the game
	game(input, rand);
    }

    //-----------------------------------------------------------------------
    // Game Method
    // game(Scanner object, Random object)
    //-----------------------------------------------------------------------
    
    public static void game(Scanner input, Random rand) {
	
	// Print the instructions to the console
	printInstructions();
	
	// Set the state to 1 or -1, depending on the user's answer
	int gameState = getFirstRunState(input);
	    
	// Valid answer flag for 'y' and 'n' commands
	boolean validAnswer = false;
	
	// Players' scores
	int p1Score = 0;
	int p2Score = 0;
	    
	// While the program is running
	while (gameState != -1) {
	
	    // Reset players' scores
	    p1Score = 0;
	    p2Score = 0;
	    
	    // While the game is running
	    while (gameState == 1) {
		
		// Add the accumulated points for player 1 to their score
		p1Score += playerTurn(1, rand, input);
		
		// If a win is detected, print the winner and set the game
		// state to 0.
		gameState = (checkScores(p1Score, p2Score));
		
		// If the game state is 0, end the loop immediately
		if(gameState == 0) break;
		
		// Add the accumulated points for player 2 to their score
		p2Score += playerTurn(2, rand, input);
		
		// If a win is detected, print the winner and set the game
		// state to 0.
		gameState = (checkScores(p1Score, p2Score));
	    }
	
	    // Reset the valid answer flag to false
	    validAnswer = false;
	
	    // While the user doesn't give a 'y' or 'n' answer,
	    while(!validAnswer) {
		
		// Prompt the user if they want to play again
		System.out.print("Do you want to play AGAIN (y/n)? ");
		String choice = input.nextLine().toLowerCase();
		
		// If yes,
		if(choice.equals("y")) {
		    
		    // Set the answer flag to true and the game state to 1
		    validAnswer = true;
		    gameState = 1;
		    
		// If no,
		} else if (choice.equals("n")) {
		    
		    // Set the answer flag to true and the game state to -1
		    validAnswer = true;
		    gameState = -1;
		    
		// If they entered an illegal answer,
		} else {
		    
		    // Inform the player of the legal commands and loop again
		    System.out.println("You must answer y or n.");
		}
		
	    }
	    
	}
    }
    
    //-----------------------------------------------------------------------
    // Prints the players' scores, and returns 0 if there is a winner.
    //-----------------------------------------------------------------------
    
    public static int checkScores(int p1, int p2) {
	
	// Initialize the game state as 1
	int state = 1;
	
	// Print the current scores.
	System.out.println();
	System.out.println("Score");
	System.out.println("Player 1: " + p1);
	System.out.println("Player 2: " + p2);
	
	// If player 1 wins
	if(p1 >= 100) {
	    
	    // Set the state to 0 and announce player 1's win
	    state = 0;
	    System.out.println("Player 1 wins");
	    
	// If player 2 wins
	} else if (p2 >= 100) {
	    
	    // Set the state to 0 and announce player 2's win
	    state = 0;
	    System.out.println("Player 2 wins");
	}
	
	// Return the game state
	return state;
    }
    
    
    
    //-----------------------------------------------------------------------
    // Gets the game state on first run. If the user enters 'y', it will
    // return 1, and will return 0 for 'n'. Entries are case insensivite.
    // getFirstRunState(Scanner object)
    //-----------------------------------------------------------------------
    
    public static int getFirstRunState(Scanner sc) {
	
	// Initialze the choice as 0
	int gameChoice = 0;
	
	// While the user hasn't decided if they want to play or not,
	while(gameChoice == 0) {
	    
	    // Prompt the user and store to a variable
	    System.out.print("Do you want to play (y/n)? ");
	    String playCommand = sc.nextLine().toLowerCase();
	    
	    // If yes,
	    if(playCommand.equals("y")) {
		
		// Set the choice to 1
		gameChoice = 1;
		
	    // If no,
	    } else if (playCommand.equals("n")) {
		
		// Set the choice to -1
		gameChoice = -1;
		
	    // If they entered an illegal answer,
	    } else {
		
		// Inform the player of the legal commands and loop again
		System.out.println("You must answer y or n.");
	    }
	}
	
	// Returns the choice
	return gameChoice;
    }
    
    //-----------------------------------------------------------------------
    // Player's turn.
    // playerTurn(Player number (1 or 2), Random object)
    //-----------------------------------------------------------------------
    
    public static int playerTurn(int pl, Random rand, Scanner sc) {
	
	// Initialize the temporary points and quit flag
	int sum = 0;
	boolean quitFlag = false;
	
	// Print the player banner
	System.out.println();
	System.out.println("PLAYER " + pl + 
		" ************************************ rolling...");
	
	// Generate a random number between 1 and 6
	int roll = rollD6(rand);
	
	// If the roll was a 1
	if(roll < 2) {
	    System.out.println("You rolled a 1. Sorry!");
	}
	
	// If a 1 was not rolled on the first roll or the user stops rolling
	while(roll > 1 && !quitFlag) {
	    
	    // Prompt for another roll
	    System.out.print("Roll again (y/n)? ");
	    String rollCommand = sc.nextLine().toLowerCase();
	    
	    // If yes,
	    if (rollCommand.equals("y")) {
		
		// Roll another dice
		roll = rollD6(rand);
		
		// If the roll is between 2 and 6,
		if(roll > 1 && roll < 7) {
		    
		    // Add that roll to the accumulating variable
		    sum += roll;
		    
		// If it's something else (can only be 1)
		} else {
		    
		    // Print that the player rolled a 1
		    System.out.println("You rolled a 1. Sorry!");
		    
		    // Set the accumulated sum to 0.
		    sum = 0;
		}
		
	    // If no,
	    } else if (rollCommand.equals("n")) {
		
		System.out.println("A wise choice");
		
		// Add that roll to the accumulating variable
		sum += roll;
		
		// Set the quit flag to true
		quitFlag = true;
		
	    // If something illegal is entered,
	    } else {
		
		// Inform the player of the legal commands and loop again
		System.out.println("You must answer y or n.");
	    }
	    
	}
	
	// Return the accumulated points
	return sum;
	
    }
    
    //-----------------------------------------------------------------------
    // Rolls a six-sided die and prints the roll
    //-----------------------------------------------------------------------
    
    public static int rollD6(Random rand) {
	
	// Generate a random number between 1 and 6
	int roll = rand.nextInt(6) + 1;
	
	// Print the roll
	System.out.println("roll: " + roll);
	
	// Return the roll
	return roll;
    }
    
    
    //-----------------------------------------------------------------------
    // Prints instructions for this game.
    //-----------------------------------------------------------------------
    
    public static void printInstructions() {
	System.out.println();
	System.out.println("Welcome to the game of \"pig\".");
	System.out.println("This is a two-­player game.");
	System.out.println("The first player rolls a 6-­sided die.");
	System.out.println("The player can roll as many times as she/he");
	System.out.println("likes until she/he wishes to stop or gets a 1.");
	System.out.println("If the first player chooses to stop, she/he");
	System.out.println("gets the sum of all her/his rolls added to");
	System.out.println("her/his score. If the first player stops because");
	System.out.println("she/he has rolled a one, she/he gets no points");
	System.out.println("for that turn. The first player to reach 100");
	System.out.println("points wins the game.");
    }
}