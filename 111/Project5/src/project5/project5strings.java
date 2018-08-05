package project5;
import java.io.*;
import java.util.Scanner;
/** @author RobertFlorence
 * Prof. Ferguson
 * Comp Sci. 111
 * Reads strings from file, alphabetizes them, and writes them to a new file
 */
public class project5strings {

    public static void main(String[] args) throws Exception {
        File daytuh = new File("inputstrings.txt");
        File newdata = new File("strdataout.txt");
        Scanner scanner = new Scanner(daytuh);
        PrintWriter pw = new PrintWriter(newdata);

        int count = 0;
        String strvalues[];
        int filesize, mid;

        filesize = scanner.nextInt();

        strvalues = new String[filesize];

        while (count < filesize) {
            strvalues[count++] = scanner.nextLine();
        }
        scanner.close();

        strvalues = sortstrings(strvalues);
        count = 0;
        pw.println(filesize);

        while (count < filesize) {
            pw.println(strvalues[count++]);
        }
        mid = (filesize / 2);
        pw.println("");
        pw.println("middle slot of array is " + mid);
        pw.println("middle string is "+strvalues[mid]);
        pw.close();
    }
    public static String[] sortstrings(String list[]) {
        
        for (int target = list.length - 1; target >= 1; target--) {

            String max = list[0];
            int Index = 0;
            for (int scanpos = 1; scanpos <= target; scanpos++) {

                if (max.compareToIgnoreCase(list[scanpos]) < 0 ) {
                    max = list[scanpos];
                    Index = scanpos;
                }
            }
            if (Index != target) {

                list[Index] = list[target];
                list[target] = max;
            }
        }
        return list;
    }
}