import java.util.Scanner;
/**
 *
 * @author RobertFlorence
 * Sept 4th, 2012
 * CS111 lab 
 * 
 * 
 */
public class ConvertTemp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner Robert = new Scanner(System.in);
       System.out.println("---Celsius to Fahrenheit Calculator---");
       
		double fnum, cnum;

                
		System.out.print("Enter Celsius: ");

		cnum = Robert.nextDouble();
                
                 Robert.close();

                System.out.print("Fahrenheit = ");
       
		System.out.println((cnum * 1.8) + 32);
   
    }
}