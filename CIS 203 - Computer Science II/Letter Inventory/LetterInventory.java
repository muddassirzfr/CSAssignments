 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 3
   *  Due: 2/14/14
   */

import java.util.*;

//=======================================================================
// This class handles a letter inventory. The inventory will contain
// counts of all letters it receives.
//=======================================================================

public class LetterInventory {
    
    private List<Integer> letterFreq = new ArrayList<Integer>();
    private int inventorySize;
    
    // ------------------------------------------------------------------
    // Tests if two strings are anagrams of each other.
    // Parameters: s1 - The first string to test
    //		   s2 - The second string to test
    // Returns: true if the strings contain the same letters.
    public static boolean anagrams(String s1, String s2) {
	return (new LetterInventory(s1).equals(new LetterInventory(s2)));
    }
    
    // ------------------------------------------------------------------
    // Default Constructor
    // Parameters: data - A string containing letters. Ignores symbols
    //             and case.
    // Postcondition: Initializes a new LetterInventory object that
    //                contains the frequencies of each letter passed.
    public LetterInventory(String data) {
	this.inventorySize = 0;
	data = normalize(data);
	for(int i = 0; i < 26; i++)
	    this.letterFreq.add(0);
	for(int i = 0; i < data.length(); i++) {
	    char c = data.charAt(i);
	    int count = this.letterFreq.get(c - 'a');
	    this.letterFreq.set(c - 'a', ++count);
	    this.inventorySize++;
	}
    }
    
    // ------------------------------------------------------------------
    // Gets the frequency of a passed letter in the collection.
    // Parameters: letter - the character to check.
    // Returns: An integer of the frequency of the letter.
    public int get(char letter) {
	if(isUpperCase(letter)) {
	    letter = toLowerCase(letter);
	}
	return this.letterFreq.get(letter - 'a');
    }
    
    // ------------------------------------------------------------------
    // Sets the specified character frequency to a specified value.
    // Parameters: letter - the character to set the frequency of
    //             value - the value to set the frequency to.
    // Postcondition: The specified frequency will be set to the
    //                specified value.
    public void set(char letter, int value) {
	if(!isLegalChar(letter) || value < 0)
	    throw new IllegalArgumentException();
	else if(isUpperCase(letter))
	    letter = toLowerCase(letter);
	this.inventorySize += (value - this.get(letter));
	this.letterFreq.set(letter - 'a', value);
    }
    
    // ------------------------------------------------------------------
    // Returns: The amount of letters in the collection.
    public int size() {
	return this.inventorySize;
    }
    
    // ------------------------------------------------------------------
    // Returns: true if the list is empty; false if not.
    public boolean isEmpty() {
	return (this.inventorySize == 0);
    }

    // ------------------------------------------------------------------
    // Returns: A string representation of the collection.
    public String toString() {
	String result = "[";
	for(int i = 0; i < 26; i++) {
	    int count = this.letterFreq.get(i);
	    for(int j = 0; j < count; j++) {
		result += (char)('a' + i);
	    }
	}
	return result + "]";
    }

    // ------------------------------------------------------------------
    // Checks if this is equal to an object.
    // Parameters: obj - An object to compare with the collection.
    // Returns: true if the LetterInventories are equal; false if they
    //          are not or the passed object is not a LetterInventory.
    public boolean equals (Object obj) {
	if(!(obj instanceof LetterInventory))
	    return false;
	LetterInventory li = (LetterInventory)obj;
	if(li.size() != this.size())
	    return false;
	for(int i = 'a'; i < 'z'; i++) {
	    if(li.get((char)i) != this.get((char)i)) {
		return false;
	    }
	}
	return true;
    }
    
    // ------------------------------------------------------------------
    // Adds another LetterInventory to this LetterInventory.
    // Precondition: A LetterInventory must not be null.
    // Parameters: other - The other LetterInventory to add from.
    // Returns: A new LetterInventory that contains both inventories.
    public LetterInventory add(LetterInventory other) {
	LetterInventory result = new LetterInventory("");
	for(int i = 0; i < 26; i++) {
	    int value1 = this.letterFreq.get(i);
	    int value2 = other.letterFreq.get(i);
	    result.letterFreq.set(i, value1 + value2);
	    result.inventorySize += (value1 + value2);
	}
	return result;
    }
    
    // ------------------------------------------------------------------
    // Subtracts a passed LetterInventory's inventory from this one.
    // Parameters: other - The other LetterInventory that contains which
    //             letters to subtract.
    // Returns: A new LetterInventory that contains the difference
    //          between them.
    public LetterInventory subtract(LetterInventory other) {
	LetterInventory result = new LetterInventory("");
	for(int i = 0; i < 26; i++) {
	    int value1 = this.letterFreq.get(i);
	    int value2 = other.letterFreq.get(i);
	    result.letterFreq.set(i, value1 - value2);
	    result.inventorySize += (value1 - value2);
	    if(result.letterFreq.get(i) < 0)
		return null;
	}
	return result;
    }
    
    // ------------------------------------------------------------------
    // Checks if a character is uppercase.
    // Parameters: c - The character to check.
    // Returns: true if it is uppercase; false if not.
    private static boolean isUpperCase(char c) {
	return (c >= 'A' && c <= 'Z');
    }
    
    // ------------------------------------------------------------------
    // Checks if a character is a lowercase or uppercase character
    // Parameters: c - The character to check.
    // Returns: true if it is legal; false if not.
    private static boolean isLegalChar(char c) {
	return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
    
    // ------------------------------------------------------------------
    // Converts a chracter to lowercase.
    // Precondition: the passed character must be already uppercase.
    // Parameters: c - The character to convert.
    // Returns: The lowercase version of a character.
    private static char toLowerCase(char c) {
	return (char)(c - 'A' + 'a');
    }
    
    // ------------------------------------------------------------------
    // Removes all symbols and converts them to lowercase.
    // Parameters: s - The string containing various characters.
    // Returns: The passed string with all symbols and spaces removed,
    //          and all letters converted to lowercase.
    private static String normalize(String s) {
	String result = "";
	for(int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if(!isLegalChar(c))
		continue;
	    else if(isUpperCase(c))
		c =  toLowerCase(c);
	    result += c;
	}
	return result;
    }
}