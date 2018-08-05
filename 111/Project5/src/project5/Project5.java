package project5;
import java.io.*;
import java.util.Scanner;

/** @author RobertFlorence
 * Prof. Ferguson
 * Comp Sci. 111
 * Reads data from file, sorts in ascending order,and writes data to a new file
 */
public class Project5 {

    public static void main(String[] args) throws Exception {
        File daytuh = new File("inputnumbers.txt");
        File newdata = new File("dataout.txt");
        Scanner scanner = new Scanner(daytuh);
        PrintWriter pw = new PrintWriter(newdata);

        int count = 0;
        int values[];
        int filesize;
        double sum = 0;
        double avg = 0;

        filesize = scanner.nextInt();

        values = new int[filesize];

        while (count < filesize) {
            values[count++] = scanner.nextInt();
        }
        scanner.close();

        values = sort(values);
        count = 0;
        pw.println(filesize);

        while (count < filesize) {
            pw.println(values[count++]);
        }
        count = 0;
        while (count < filesize) {
            sum += values[count++];
        }

        avg = (sum / filesize);
        pw.println("sum = " + sum);
        pw.println("average = " + avg);
        pw.close();
    }
    public static int[] sort(int list[]) {

        for (int target = list.length - 1; target >= 1; target--) {

            int max = list[0];
            int Index = 0;
            for (int scanpos = 1; scanpos <= target; scanpos++) {

                if (max < list[scanpos]) {
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