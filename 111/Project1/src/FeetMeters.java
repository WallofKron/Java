import java.util.Scanner;
/**
 *
 * @author RobertFlorence
 * Sept 4th, 2012
 * CS111 lab 
 * 
 * 
 */
public class FeetMeters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner Robert = new Scanner(System.in);

        
     System.out.println("---Convert Feet to Meters---");
     System.out.println(" ");
     
       double feet, meter;     
     
 System.out.print("Enter Feet to be converted: ");
 
     feet = Robert.nextDouble();
     
        Robert.close();
 
     meter = feet * .305;
     
     System.out.println("Meters: ");
        
        System.out.println(meter);
             
    }
}