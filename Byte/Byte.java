 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 1
   *  Due: 1/29/14
   */

//===================================================================
// This class handles a Byte object. A byte is a series of eight
// 1's or 0's represented in Base-2.
//===================================================================
 
public class Byte {
    
//===================================================================
// Instance Variables
//===================================================================
    
    private int[] bits;		// Array containing 8 bits
    
//===================================================================
// Constructors
//===================================================================
    
    // Default constructor
    // Postcondition: Creates a new byte with the value 0.
    public Byte() {
	this(0);
    }
    
    // Parameter: n - value to set the byte to
    // Postcondition: Creates a new byte with the value n.
    public Byte(int n) {
	this.bits = new int[8];
	this.set(n);
    }
    
    
//===================================================================
// Instance Methods - Informative
//===================================================================
    
    // --------------------------------------------------------------
    // Returns: The value of the byte as an integer
    public int decimalValue() {
	int result = 0;
	
	// Copy the byte to a temporary one
	Byte temp = new Byte();
	temp.add(this);
	
	// If the byte is negative
	if(temp.bits[7] == 1) {
	    
	    // Decode the two's compliment
	    temp.add(-1);
	    temp.xor(new Byte(255));
	}
	
	// Accumulate each bit's value
	for(int i = 0; i < 8; i++) {
	    result += (temp.bits[i] * (Math.pow(2, i)));
	}
	
	// If the byte is positive, return the result, if it is
	// negative, return the a negated result.
	// Ternary operator: (check) ? <IF TRUE> : <IF FALSE>;
	return (this.bits[7] == 0) ? result : -result;
    }

    //---------------------------------------------------------------
    // Returns: a string of 8 bits for each bit in the byte
    public String toString() {
	String result = "";
	
	// Append each bit to the result in reverse order
	for (int i = 7; i >= 0; i--) {
	    result += this.bits[i];
	}
	return result;
    }
    
    //---------------------------------------------------------------
    // Parameter: other - a different Byte object to compare the
    // 			  Byte with.
    // Returns: true if the Byte has the same value as the passed
    //		Byte.
    public boolean equals(Byte other) {
	return (this.decimalValue() == other.decimalValue());
    }
    
    
//===================================================================
// Instance Methods - Zero Parameter Mutators
//===================================================================
    
    // --------------------------------------------------------------
    // Postcondition: Negates the byte to the two's compliment
    //		      version.
    public void negate() {
	
	// Invert all bits by XOR-ing 11111111
	this.xor(new Byte(255));
	this.add(1);
    }
    
    //---------------------------------------------------------------
    // Postcondition: shifts all bits to the left, and carries the
    // 		      most significant bit to the least significant
    //		      bit's index.
    public void rol(){
	
	// Set the least significant bit
	int lsb = this.bits[7];
	
	// A right shift (left in the example and in memory) is
	// equivalent to multiplying by two.
	this.add(this.decimalValue() + lsb);
    }
    
    //---------------------------------------------------------------
    // Postcondition: shifts all bits to the right, and carries the
    // 		      least significant bit to the most significant
    //		      bit's index.
    public void ror(){
	
	// Set the most significant bit
	int msb = this.bits[0];
	
	// Division by two did not seem to work, so each bit becomes
	// the bit in the next index
	for (int i = 0; i < 7; i++){
	    this.bits[i] = this.bits[i + 1];
	}
	
	// Replace the rotated bit
	this.bits[7] = msb;
    }
    
    
//===================================================================
// Instance Methods - Single Parameter Mutators
//===================================================================
    
    //---------------------------------------------------------------
    // Parameter: n - the value to set the byte to.
    // Postcondition: the byte will take on the value n.
    public void set(int n) {
	int tempValue = n;
	for(int i = 0; i < 8; i++) {
	    
	    // If the number is odd (ingore sign)
	    if(Math.abs(tempValue) % 2 == 1)
		this.bits[i] = 1;
	    else
		this.bits[i] = 0;
	    
	    // Divide by two to set up for next iteration
	    tempValue /= 2; 
	}
	
	// If the original value was negative, negate the result
	if(n < 0)
	    this.negate();
    }
    
    //---------------------------------------------------------------
    // Parameter: other - a different Byte object to perform the XOR
    // 			  operation with.
    // Postcondition: each bit in the Byte will become a 0 if both
    // 		      cooresponding bits are equal, and a 1 if both
    // 		      cooresponding bits are different.
    public void xor(Byte other) {
	for(int i = 0; i < 8; i++) {
	    
	    // Set the bit to 0 if it is the same as the passed bit,
	    // and to 1 if they are different
	    this.bits[i] = (this.bits[i] == other.bits[i]) ? 0 : 1;
	}
    }
    
    //---------------------------------------------------------------
    // Parameter: other - a different Byte object to add to the byte.
    // Postcondition: the Byte will become the sum of itself and the
    //                passed Byte.
    public void add(Byte other) {
	int carry = 0;
	for(int i = 0; i < 8; i++) {
	    
	    // Add bit A, B, and the carry
	    int total = this.bits[i] + other.bits[i] + carry;
	    
	    // Set the bit to 1 if odd, and 0 if even
	    this.bits[i] = total % 2;
	    
	    // If the total would generate a carry, set the carry
	    // bit to 1. Otherwise, reset to 0
	    carry = (total > 1) ? 1 : 0;
	    total = 0;
	}
    }
    
    //---------------------------------------------------------------
    // Parameter: n - the value to add to the Byte.
    // Postcondition: the Byte will become the sum of itself and the
    //                passed integer.
    public void add(int n) {
	this.add(new Byte(n));
    }
    
    //---------------------------------------------------------------
    // Parameter: other - a different Byte object to be subtracted
    //		          from the Byte.
    // Postcondition: the Byte will become the difference of itself
    // 		      and the passed Byte.
    public void subtract(Byte other) {
	Byte temp = new Byte(other.decimalValue());
	temp.negate();
	this.add(temp);
    }
    
    //---------------------------------------------------------------
    // Parameter: n - the value to subtract from the Byte.
    // Postcondition: the Byte will become the difference of itself
    // 		      and the passed integer.
    public void subtract(int n) {
	Byte bOther = new Byte(-n);
	this.add(bOther);
    }
}