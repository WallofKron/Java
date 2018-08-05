package projecttwo;

import java.util.Scanner;
/**
 * @author RobertFlorence Comp Sci 182 Project 0
 * User input class takes input and checks
 */
public class UserInput {

    public static int getInt(int min, int max) throws Exception {
        int testint = getInt();

        while (!(testint > min) || !(testint <= max)) {
            System.out.print("Please try again: ");
            testint = getInt();
        }
        return testint;
    }

    public static char getChar(char min, char max) throws Exception {
        char testchar = getChar();

        while (testchar < min || testchar > max) {
            System.out.print("Please try again: ");
            testchar = getChar();
        }
        return testchar;
    }

    public static double getDouble(double min, double max) throws Exception {
        double testdub = getDouble();

        while (!(testdub > min) || !(testdub <= max)) {
            System.out.print("Please try again: ");
            testdub = getDouble();
        }
        return testdub;
    }

    public static String getString(int min, int max) throws Exception {
        String teststr = getString();

        while (!(teststr.length() >= min) || !(teststr.length() <= max)) {
            System.out.print("Please try again: ");
            teststr = getString();
        }
        return teststr;
    }

    public static String getString() throws Exception {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        return s;

    }

    public static char getChar() throws Exception {

        String s = getString();

        return s.charAt(0);

    }

    public static int getInt() throws Exception {

        String s = getString();

        return Integer.parseInt(s);

    }

    public static double getDouble() throws Exception {

        String s = getString();

        Double adub = Double.parseDouble(s);
        return adub.doubleValue();

    }
}