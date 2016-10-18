/*
 * Name: Tim Backus
 * Course: CIS 203 - Computer Science II
 * Assignment: 11 (Bonus)
 * Due: 5/15/14
 */

import java.util.Scanner;

//=============================================================================
// This class will find a solution to the N-Queens problem. That is, placing
// N Queens on a chessboard until none can attack each other.
//=============================================================================

public class NQueens {

	public static void main(String[] args) {
		
		// If a board size isn't passed at runtime, prompt the user for one.
		// The user can also enter "UPTO N" to run all test up to the
		// specified N.
		int size = 4;
		int upperLimit = size;
		if(args.length >= 1) {
			if(args[0].equals("UPTO".toUpperCase())) {
				size = 1;
				upperLimit = Integer.parseInt(args[1]);
			} else {
				size = Integer.parseInt(args[0]);
				upperLimit = size;
			}
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a board size: ");
			size = sc.nextInt();
		}
		
		for(int i = size; i <= upperLimit; i++) {
			System.out.println("Solving for N = " + i + ":");
			NQueens main = new NQueens(i);
			System.out.println();
		}
			
	}
	
	//-------------------------------------------------------------------------
	// Default Constructor
	// Parameter: size: The board's length, width, and the number of queens.
	public NQueens(int size) {
		Board board = new Board(size);
		board.solve();
	}
	
	//-------------------------------------------------------------------------
	// Board Class
	private class Board {
		
		private final int SIZE;
		private int[] queens;	
		
		//---------------------------------------------------------------------
		// Default Constructor
		// parameter: boardSize: The length and width of the board.
		public Board(int boardSize) {
			SIZE = boardSize;
			
			// A 2D array is not necessary, as there can only be one Queen per
			// column.
			queens = new int[SIZE];
			
			// Initialize all queens as -1, since 0 is the top row.
			for(int i = 0; i < queens.length; i++)
				queens[i] = -1;
		}
		
		//---------------------------------------------------------------------
		// Solve Wrapper Method
		public void solve() {
			if(!solve(0)) {
				System.out.println("UNSOLVABLE");
			} else {
				drawBoard();			
			}
				
		}
		
		//---------------------------------------------------------------------
		// Recursive Solve Method
		// Parameter: col: The current column to add a Queen to.
		// Precondition: A Board object must have been initialized.
		// Returns: true if the call could place a Queen, false if not.
		private boolean solve(int col) {
			
			// If we reach out of bounds, we've placed the last Queen.
			if(col >= SIZE)
				return true;
			
			// For each Y position
			for(int row = 0; row < SIZE; row++) {
				
				// Set this Queen's position to the next safe spot.
				if(isSafe(col, row)) {
					queens[col] = row;
					
					// If the solution is found working down the line, 
					// return true.
					if(solve(col + 1))
						return true;
					
					// Otherwise, take this Queen off the board, and try
					// the next position.
					queens[col] = -1;
				}
			}
			
			// We've failed to place a Queen, so backtrack, or pronounce the
			// problem impossible if we're in the first column.
			return false;
		}
		
		//---------------------------------------------------------------------
		// Checks if a Queen can be attacked.
		// Parameters: col: The column to place a Queen at.
		//             row: The row to place a Queen at.
		// Returns: true if a Queen is not found in the same row or diagonally.
		private boolean isSafe(int col, int row) {
			
			// A Queen can always be safely placed in the first column.
			if(col == 0)
				return true;
			for(int i = 0; i < SIZE; i++) {
				if(queens[i] == -1)
					break;
				
				// If a duplicate row entry is found, it can be attacked.
				if(queens[i] == row)
					return false;
				
				// If the difference in the columns equal the difference in
				// rows, it can be attacked diagonally.
				if(Math.abs(col - i) == Math.abs(row - queens[i]))
					return false;
			}
			return true;
		}
		
		//---------------------------------------------------------------------
		// Prints the solution.
		private void drawBoard() {
			for(int row = 0; row < SIZE; row++) {
				for(int col = 0; col < SIZE; col++) {
					char tile = '.';
					if(queens[col] == row)
						tile = 'Q';
					System.out.print(tile + " ");
				}
				System.out.println();
			}
		}
	}
}