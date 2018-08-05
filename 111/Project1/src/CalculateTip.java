import java.util.Scanner;
/**
 *
 * @author RobertFlorence
 * Sept 4th, 2012
 * CS111 lab 
 * 
 * 
 */
public class CalculateTip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Scanner Robert = new Scanner(System.in);
       
        Double tip, tiprate, subtotal, ftotal;
       
        System.out.println("---Calculate Tip(20%) and Bill Total---");
             System.out.println(" ");  
        
        System.out.print("Enter Bill Total: ");
       
        subtotal = Robert.nextDouble();
        
        tiprate = 0.2;
          
          tip = (subtotal * tiprate);
          
          ftotal = tip + subtotal;
        
          System.out.println("Tip Amount: " +tip);
          
        System.out.println("Final Total: " +ftotal);
        
        Robert.close();
    }
}