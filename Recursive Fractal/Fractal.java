 /**
   *  Name: Timothy Backus
   *  Course: CIS 203 - Computer Science II
   *  Assignment: 5
   *  Due: 3/5/14
   */

//===================================================================
// This class handles the Fractal object. This fractal can be scaled
// and padded from the left.
//===================================================================
 
public class Fractal {
    
    private int level;
    private int padding;
    
    // --------------------------------------------------------------
    // Default constructor
    // Postcondition: Initializes a new Fractal object with scale 3,
    //                and padding 0.
    public Fractal() {
	this.level = 3;
	this.padding = 0;
    }
    
    // --------------------------------------------------------------
    // Scaled constructor
    // Parameter: lv: The scale to draw the Fractal.
    // Postcondition: Initializes a new Fractal object with the
    //                desired scale, and no padding.
    public Fractal(int lv) {
	this.level = lv;
	this.padding = 0;
    }
    
    // --------------------------------------------------------------
    // Padding-enabled constructor
    // Parameter: lv: The scale to draw the Fractal.
    //            pad: The amount of padding to add.
    // Postcondition: Initializes a new Fractal object with the
    //                desired scale and padding.
    public Fractal(int lv, int pad) {
	this.level = lv;
	this.padding = pad;
    }

    // --------------------------------------------------------------
    // Recursive method for drawing the figure. Must be called from
    //   within a print() method, or nothing will be output.
    // Parameter: lv: The scale to draw the Fractal.
    //            pad: The amount of padding to add.
    // Returns: A String containing the fractal.
    public static String figure(int lv, int pad) {
	if(lv <= 0) {
	    return drawSymbol(pad, " ") + "*\n";
	} else {
	    return figure((lv - 1), pad) + 
		    drawSymbol(pad, " ") +
		    drawSymbol((int)Math.pow(2, lv), "*") +
		    "\n" + 
		    figure((lv - 1), pad + ((int)Math.pow(2, lv - 1)));
	}
    }
 
    // --------------------------------------------------------------
    // Returns the String built by the figure() method. Implemented
    // so print(<Fractal reference>) will print the Fractal itself
    // instead of the memory address.
    // Returns: A String containing the fractal.
    private String toString() {
	return figure(this.level, this.padding);
    }

    // --------------------------------------------------------------
    // Builds a String containing a specified number of repeated 
    //   Strings.
    // Parameter: num: Number of spaces to return.
    //            s: The string to repeat.
    // Returns: A String containing the repeated Strings.
    public static String drawSymbol(int num, String s) {
	if (num <= 0) {
	    return "";
	}
	else if(num == 1) {
	    return s;
	} else {
	    return s + drawSymbol(num - 1, s);
	}
    }
}