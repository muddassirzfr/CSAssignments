public class FractalDemo {
    public static void main (String [] args) {
	Fractal f = null;
	if(args.length == 0) {
 	    f = new Fractal(3);
 	}
 	else if (args.length == 1) {
 	    f = new Fractal(Integer.parseInt(args[0]), 0);
 	}
 	else if (args.length == 2) {
 	    f = new Fractal(Integer.parseInt(args[0]),
 		                    Integer.parseInt(args[1]));
 	}
 	System.out.print(f);
    }

}