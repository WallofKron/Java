package pkg282project0;

import java.io.*;
import java.util.Scanner;

/**
 * @author RobertFlorence cs 282 Prof. Ferguson Fall 2013
 */
public class project0 {

    public static void main(String[] args) throws Exception {
        File data = new File("data.txt");
        File dataout = new File("fixeddata.txt");
        String contents = null;
        PrintWriter pw = new PrintWriter(dataout);
        Scanner scan = new Scanner(data);
        
        readfile(data);
    }

    public static Scanner readfile (data) throws Exception {


        while (scan.hasNext()) {
            contents = scan.nextLine();

            System.out.println(contents);
            
            return da;
        }
    }
}