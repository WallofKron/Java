import javax.swing.JOptionPane;
/**
 *
 * @author RobertFlorence
 * Sept 4th, 2012
 * CS111 lab 
 * 
 */
public class CalculateTipGUI {
    public static void main(String[] args) {
        
            String subtotal = JOptionPane.showInputDialog("Enter Bill Total: ");
    double stotal = Double.parseDouble(subtotal);
        
    
        String tiprate = JOptionPane.showInputDialog("Enter tip percentage: ");
    double trate = Double.parseDouble(tiprate);
       
    
        double tip = (trate/100) * stotal;
        
        double ftotal = tip + stotal;
        
        String output = "Total tip given: " + tip + "\nFinal Bill Total: " + ftotal;
        
        JOptionPane.showMessageDialog(null,output);
     }   
}