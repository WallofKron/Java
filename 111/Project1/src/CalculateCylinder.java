import java.util.Scanner;
/**
 *
 * @author RobertFlorence
 * Sept 4th, 2012
 * CS111 lab 
 * 
 * 
 */
public class CalculateCylinder {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Scanner Robert = new Scanner(System.in);
        
    System.out.println("---Calculate The Volume of A Cylinder---");
    System.out.println(" ");
        
    double area, volume, length, radius, diameter, radiussquared;

    		System.out.print("Enter Radius: ");

		radius = Robert.nextDouble();

                System.out.print("Enter Length: ");

		length = Robert.nextDouble();

    radiussquared = radius * radius;
                
    diameter = radius + radius;
                
    area = radiussquared * 3.14159;
    
    volume = area * length;
    
    System.out.print("Diameter = ");
    System.out.println(diameter);

    System.out.print("Area = ");
    System.out.println(area);
    
    System.out.print("Volume = ");
    System.out.println(volume);
    
    //Diameter = 2r
    
    Robert.close();
    }
}