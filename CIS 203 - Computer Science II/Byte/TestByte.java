import java.io.*;

public class TestByte {

    public static PrintStream ps = System.out;
    public static int totalPoints = 0;
    public static int totalPointsPossible = 0;

    public static void main (String [] args) {
	test1();
	test2();
	test3();
	test4();
	test5();
	test6();
	test7();
	test8();
	test9();
	test10();
	test11();
	test12();
	test13();
    }

    public static void test1() {
        int score = 0;
	int total = 4;
	ps.println("** Testing constructor: new Byte(int n)... ");
	ps.println("** Testing version 1 of set(n)...");
	ps.println("** Testing toString()...");
	Byte b = new Byte(10);
	if (b.toString().equals("00001010")) {
	    ps.println("PASS");
            score++; }
        else 
            ps.println("FAIL");
	b = new Byte(0);
	if (b.toString().equals("00000000")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	b.set(127);
	if (b.toString().equals("01111111")) {
	    ps.println("PASS");
            score++; }
        else 
            ps.println("FAIL");
	b.set(0);
	if (b.toString().equals("00000000")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	report(score, total);
    }

    public static void test2() {
        int score = 0;
	int total = 1;
	ps.println("\n** Testing constructor: new Byte()...");
	Byte b = new Byte();
	if (b.toString().equals("00000000")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	report(score, total);
    }

    public static void test3() {
        int score = 0;
	int total = 3;
	ps.println("\n** Testing add(Byte other)... ");
	Byte b1 = new Byte(12);
	Byte b2 = new Byte(5);
	b1.add(b2);
	if (b1.toString().equals("00010001") &&
            b2.toString().equals("00000101")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	b1 = new Byte(126);
	b2 = new Byte(0);
	b1.add(b2);
	if (b1.toString().equals("01111110") &&
            b2.toString().equals("00000000")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	b2.set(1);
	b1.add(b2);
	if (b1.toString().equals("01111111") &&
            b2.toString().equals("00000001")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	report(score, total);
    }

    public static void test4() {
        int score = 0;
	int total = 3;
	ps.println("\n** Testing add(int n)... ");
	Byte b = new Byte(10);
	b.add(3);
	if (b.toString().equals("00001101")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
        b.add(114);
	if (b.toString().equals("01111111")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	b.add(0);
	if (b.toString().equals("01111111")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	report(score, total);
    }


    public static void test5() {
        int score = 0;
	int total = 3;
	ps.println("\n** Testing negate()... ");
	Byte b = new Byte(5);
	b.negate();
	if (b.toString().equals("11111011")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	b.negate();
	if (b.toString().equals("00000101")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	b.set(0);
	b.negate();
	if (b.toString().equals("00000000")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	report(score, total);
    }

    public static void test6() {
        int score = 0;
	int total = 2;
	ps.println("\n** Testing version 2 of set(n)...");
	Byte b = new Byte();
	b.set(-10);
	if (b.toString().equals("11110110")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	b.set(-128);
	if (b.toString().equals("10000000")) {
            ps.println("PASS");
            score++;
	}
	else
	    ps.println("FAIL");
	report(score, total);
    }
    
    public static void test7() {
        int score = 0;
	int total = 3;
	ps.println("\n** REesting constructor: new Byte(int n)... ");
	ps.println("** REtesting add (Byte b)...");
	ps.println("** REtesting add (int n)...");
	Byte b = new Byte(-10);
	if (b.toString().equals("11110110")) {
	    ps.println("PASS");
            score++; }
        else 
            ps.println("FAIL");
	b.add(new Byte(-3));
	if (b.toString().equals("11110011")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	b.add(-4);
	if (b.toString().equals("11101111")) {
	    ps.println("PASS");
            score++; }
        else 
            ps.println("FAIL");
	report(score, total);
    }

    public static void test8() {
        int score = 0;
	int total = 3;
	ps.println("\n** Testing subtract(int n)... ");
	Byte b = new Byte();
	b.subtract(5);
	if (b.toString().equals("11111011")) {
	    ps.println("PASS");
            score++; }
        else 
            ps.println("FAIL");
	b.subtract(-6);
	if (b.toString().equals("00000001")) {
	    ps.println("PASS");
            score++; }
        else 
            ps.println("FAIL");
	b.subtract(0);
	if (b.toString().equals("00000001")) {
	    ps.println("PASS");
            score++; }
        else 
            ps.println("FAIL");
	report(score, total);
    }

    public static void test9() {
        int score = 0;
	int total = 3;
	ps.println("\n** Testing decimalValue()... ");
        Byte b = new Byte(5);
	if (b.decimalValue() == 5 && b.toString().equals("00000101")) {
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	b.set(-3);
	if (b.decimalValue() == -3 && b.toString().equals("11111101")) {
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	b = new Byte();
	if (b.decimalValue() == 0 && b.toString().equals("00000000")) {
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	report(score, total);
    }


    public static void test10() {
        int score = 0;
	int total = 4;
	ps.println("\n** Testing subtract(Byte other)... ");
        Byte b1 = new Byte(5);
	Byte b2 = new Byte(2);
	b1.subtract(b2);
	if (b1.toString().equals("00000011") &&
            b2.toString().equals("00000010")){
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
        b2.subtract(b1);
	if (b1.toString().equals("00000011") &&
            b2.toString().equals("11111111")){
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	b1.set(-127);
	b2.set(1);
	b1.subtract(b2);
	if (b1.toString().equals("10000000") &&
            b2.toString().equals("00000001")){
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	b1.set(1);
	b2.set(-126);
        b1.subtract(b2);
	if (b1.toString().equals("01111111") &&
            b2.toString().equals("10000010")){
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	report(score, total);
    }


    public static void test11() {
        int score = 0;
	int total = 4;
	ps.println("\n** Testing xor(Byte other)... ");
        Byte b1 = new Byte(5);
	Byte b2 = new Byte(-10);
	b1.xor(b2);
	if (b1.toString().equals("11110011") &&
            b2.toString().equals("11110110")){
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	b2.xor(b2);
	if (b2.toString().equals("00000000")) {
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
        b2.set(0);
        b1.xor(b2);
	if (b1.toString().equals("11110011") &&
            b2.toString().equals("00000000")){
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");
	b1.set(5);
	b2.set(-1);
	b1.xor(b2);
	if (b1.toString().equals("11111010") &&
            b2.toString().equals("11111111")){
	    ps.println("PASS");
            score++; 
	}
        else 
            ps.println("FAIL");

	report(score, total);
    }


    public static void test12() {
        int score = 0;
	int total = 4;
	ps.println("\n** Testing rol() and ror()... ");
        Byte b = new Byte(109);
	ps.println(b);
	b.ror();
	ps.println(b);
	if (b.toString().equals("10110110")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	b.rol();
	if (b.toString().equals("01101101")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	b.rol();
	if (b.toString().equals("11011010")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	for (int i = 0; i < 8; i++)
	    b.ror();
	if (b.toString().equals("11011010")) {
	    ps.println("PASS");
            score++;
	} else 
            ps.println("FAIL");
	report(score, total);
    }

    public static void test13() {
        int score = 0;
	int total = 3;
	ps.println("\n** Testing equals()... ");
        Byte b = new Byte(109);        
	if (b.equals(new Byte(109)) && new Byte(109).equals(b)) {
	    ps.println("PASS");
            score++;
	} else
            ps.println("FAIL");
	b.add(1);
	if (!b.equals(new Byte(109)) && !(new Byte(109).equals(b))) {
	    ps.println("PASS");
            score++;
	} else
            ps.println("FAIL");
	b.set(-19);
	if (!b.equals(new Byte(109)) && !(new Byte(109).equals(b))) {
	    ps.println("PASS");
            score++;
	} else
            ps.println("FAIL");

	report(score, total);
    }

    public static void report(int score, int total) {
       totalPoints += score;
       totalPointsPossible += total;
       ps.println(score + " out of " + total + " points");
       ps.println("Overall Points: " + totalPoints + " out of " +
                   totalPointsPossible);
    }
}
