/*
 * Name: Tim Backus
 * Course: CIS 203 - Computer Science II
 * Assignment: 7
 * Due: 3/21/14
 */

import java.io.*;
import java.util.*;

//===========================================================================
// This class finds anagrams of an entered word from a file containing a list
// of words. An anagram is two words that share the same counts of letters.
//===========================================================================

public class Anagram {

    private static HashSet<String> wordList = new HashSet<String>();
    
    //-----------------------------------------------------------------------
    // Default constructor
    // Parameter: fileName: Name of the dictionary file to read.
    // Postcondition: Reads the dictionary file into a Hash Set.
    // Throws: FileNotFoundException if the user specifies a non-existant file.
    public Anagram(String fileName) {
	try {
	    Scanner fileScan = new Scanner(new File(fileName));
	    buildWordList(fileScan);
	} catch (FileNotFoundException e) {
	    System.out.println(e.toString());
	    System.exit(0);
	}
    }
    
    //-----------------------------------------------------------------------
    // Finds anagrams
    // Parameter: word: The word to find anagrams of in the dictionary.
    // Precondition: An Anagram object must have already been constructed.
    // Returns: A string containing all anagrams of the entered word.
    public static String find(String word) {
	if(!wordList.contains(word))
	    return null;
	HashSet<String> anagrams = new HashSet<String>();
	for (String s : wordList) {
	    if(isAnagram(word, s))
		anagrams.add(s);
	}
	return anagrams.toString();
    }
    
    //-----------------------------------------------------------------------
    // Detects anagrams
    // Parameters: s1, s2: The two strings to compare.
    // Returns: true if the strings are anagrams of each other. False if not.
    private static boolean isAnagram(String s1, String s2) {
	if(s1.length() != s2.length())
		    return false;
	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();
	Arrays.sort(c1);
	Arrays.sort(c2);
	for(int i = 0; i < c1.length; i++) {
	    if(c1[i] != c2[i])
		return false;
	}
	return true;
    }
    
    //-----------------------------------------------------------------------
    // Reads the dictionary into a Hash Set.
    // Parameter: sc: A scanner linked to the dictionary file.
    // Postcondition: the Hash Set will be filled with dictionary words.
    private static void buildWordList(Scanner sc) {
	while(sc.hasNext()) {
	    wordList.add(sc.next());
	}
    }
}