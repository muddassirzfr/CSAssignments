/*
Name: Timothy Backus
Course: CIS 203 - Computer Science II
Assignment: 4
Due: 2/24/13
*/

import java.util.*;

//===========================================================================
// This class will control a game of Evil Hangman, which uses a dictionary to
// match words by patterns to create a list of valid words. This game will
// use the pattern with the most valid words to cheat the player.
//===========================================================================

public class EvilHangman {
    
    private int wordLength;
    private int guessesLeft;
    private boolean displayRemaining;
    private HashSet<String> wordList;
    private HashSet<Character> guessedLetters;
    private HashMap<String, HashSet<String>> patterns;
    private String currentPattern = "";
    
    //-----------------------------------------------------------------------
    // Default Constructor
    // Parameters: wordLength: How many characters the unknown word has.
    //             guesses: How many guesses the player has
    //             knowsWordsLeft: Flag to display considered word count.
    //             wordList: An ArrayList of words to consider
    // Postcondition: A new game of a cheating hangman will be initialized.
    public EvilHangman(int wordLength, int guesses, 
			boolean knowsWordsLeft, ArrayList<String> wordList) {
	this.wordLength = wordLength;
	this.guessesLeft = guesses;
	this.displayRemaining = knowsWordsLeft;
	this.guessedLetters = new HashSet<Character>();
	this.wordList = new HashSet<String>(wordList);
	this.patterns = new HashMap<String, HashSet<String>>();
	for(int i = 1; i <= this.wordLength; i++)
	    this.currentPattern += "-";
    }
    
    //-----------------------------------------------------------------------
    // Starts the game
    // Precondition: An instance of this class must have already been
    //               initialized.
    // Postcondition: A new game of a cheating hangman will be started, and
    //                will loop until the player wins or loses.
    public void play() {
    	boolean win = false;
	while(this.guessesLeft > 0) {
	    if(this.wordList.size() == 1 && 
		    (this.wordList.contains(this.currentPattern))) {
		win = true;
		break;
	    }
	    printInfo();
	    char c = promptUser();
	    while(this.guessedLetters.contains(c)) {
		System.out.println(c + " has already been guessed.");
		c = promptUser();
	    }
	    createPatterns(c);
	    this.currentPattern = getLargestPattern();
	    setWordList(this.patterns.get(this.currentPattern));
	    System.out.println(this.currentPattern);
	    this.guessedLetters.add(c);
	    this.guessesLeft--;
	}
	if(win) {
	    System.out.println("You somehow guessed" +
		    "the word! You deserve a cookie!");
	} else {
	    System.out.println("You have no guesses left. You lose.");
	    if(this.displayRemaining) {
		    System.out.println("Possible words left:");
		    System.out.println(this.wordList);
	    } else {
		    System.out.println("The correct word was " + 
					getRandomWord());
	    }
	}
    }
    
    //-----------------------------------------------------------------------
    // Creates word families
    // Parameter: c: A character to check and create groups of patterns
    //               of based on location of this character.
    // Postcondition: A HashMap of Strings as keys and a Set of Strings as
    //                values will be created and grouped cooresponding to
    //                the patterns of the passed letter.
    private void createPatterns(char c) {
    	if(this.patterns != null) {
	    this.patterns.clear();
    	}
	for(String s : this.wordList) {
	    String pattern = this.currentPattern;
	    for (int i = 0; i < pattern.length(); i++) {
		if(pattern.charAt(i) == '-') {
		    if(s.charAt(i) == c) {
			pattern = setByIndex(pattern, c, i);
		    }
		}
	    }
	    if(!this.patterns.containsKey(pattern)) {
		patterns.put(pattern, new HashSet<String>());
		patterns.get(pattern).add(s);
	    } else {
		patterns.get(pattern).add(s);
	    }
	}
    }
    
    //-----------------------------------------------------------------------
    // Grabs a random word as a "solution".
    // Precondition: The word list must not be empty or null.
    // Returns: A random word from the word list.
    private String getRandomWord() {
    	Random rand = new Random();
    	int num = rand.nextInt(this.wordList.size());
    	List<String> list = new ArrayList<String>();
    	for (String s : this.wordList) {
	    list.add(s);
    	}
    	return list.get(num);
    }
    
    //-----------------------------------------------------------------------
    // Gets the pattern with the most words.
    // Returns: The pattern with the largest amount of possible words.
    private String getLargestPattern() {
    	int max = 0;
    	String result = "";
    	for(String s : this.patterns.keySet()) {
	    if(this.patterns.get(s).size() > max) {
		max = this.patterns.get(s).size();
		result = s;
	    }
    	}
    	return result;
    }
    
    //-----------------------------------------------------------------------
    // Sets the word list to another Set.
    // Parameter: hs: A HashSet containing the new word list.
    // Postcondition: The instance's word list will now be set to the passed
    //                word list.
    private void setWordList(HashSet<String> hs){
    	this.wordList = hs;
    }
    
    //-----------------------------------------------------------------------
    // Displays various information about the game as it is played.
    private void printInfo() {
	System.out.println("Number of guesses left: " +  this.guessesLeft);
	System.out.println("Letters guessed: " +  guessedLetters);
	if(this.displayRemaining) {
	    System.out.println("Possible words left: " + 
				this.wordList.size());
	}
	System.out.println("Current pattern: " +  this.currentPattern);
    }
    
    //-----------------------------------------------------------------------
    // Sets a letter at a specified position to a specified letter.
    // Parameters: s: The String to change.
    //             c: The character to change to.
    //             index: The zero-based position to make the edit.
    // Returns: The new String with the changed letter.
    private String setByIndex(String s, char c, int index) {
	String s1 = s.substring(0, index);
	String s2 = s.substring(index + 1, s.length());
	return s1 + c + s2;
    }
    
    //-----------------------------------------------------------------------
    // Tells the player to enter a letter. If a non-letter character is 
    // entered, the player must enter another character.
    // Returns: The character the player entered.
    private char promptUser() {
	Scanner sc = new Scanner(System.in);
	System.out.print(">> ");
	char c = sc.next().toLowerCase().charAt(0);
	while(!isLegalChar(c)) {
	    System.out.println("Please enter a letter.");
	    System.out.print(">> ");
	    c = sc.next().charAt(0);
	}
	return c;
    }

    //-----------------------------------------------------------------------
    // Checks if a character is a letter.
    // Parameter: c: The character to check.
    // Returns: True if it is a letter, false if not.
    private static boolean isLegalChar(char c) {
    	return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}