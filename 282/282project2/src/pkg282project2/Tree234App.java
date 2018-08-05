package pkg282project2;
import java.io.*;

/*
 * Robert Florence
 * CS 282
 * Professor Ferguson
 * Project 2
 * This project modifys and existing 234 Tree data structure and adds
 * functionality to make it run as a b-tree data structure. Also, this 
 * project is written out to a Fake Disk that mimics a disk drive.
 * 
 */
public class Tree234App {

    static Tree234 theTree;
    static FakeDisk theDisk = new FakeDisk();
    static int sectorSize = 512;
    static int sectorNum = 0;

    public static void main(String[] args) throws IOException {
        long value;
        theTree = new Tree234();


        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, find, change, read, write, view, or quit: ");
            char choice = getChar();

            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;

                case 'w':
                    writeData();
                    break;

                case 'v':
                    theTree.displayTree();
                    break;


                case 'r':

                    readData();

                    break;

                case 'c':

                    changeOrder();

                    break;
                case 'i':
                    System.out.print("Enter Value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;

                case 'q':
                    System.exit(0);

                    break;
                case 'f':
                    System.out.print("Enter Value to Find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Could not find " + value);

                    }
                    break;

                default:
                    System.out.print("Invalid Entry\n ");
            }

        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static String readFile(File f) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {

            sb.append(line);
            sb.append("\n");

        }

        br.close();
        return sb.toString();
    }

    public static void readData() throws IOException {
        char answer;
        String filename = "";


        System.out.print("Name of the file you wish to import: ");
        filename = getString();

        theTree.displayTree();
        System.out.println("^Current Tree^");

        do {

            System.out.print("Would you like to change the order of the tree? (y/n): ");
            answer = getChar();

            switch (answer) {
                case 'y':

                    changeOrder();

                    break;

                case 'n':

                    System.out.println("Tree remains unchanged");


                    break;

                default:
                    System.out.println("Invalid Choice, try again");

            }
        } while (answer != 'y' && answer != 'n');


        File input = new File(filename);
        if (!input.exists()) {
            System.out.println("File does not exist, try again");

            return;

        }

        String contents = readFile(input);

        String record[] = contents.split("\n");
        String data[] = new String[record.length];
        String info[] = new String[record.length];


        for (int i = 0; i < record.length; i++) {
            String[] d = record[i].split(",");
            data[i] = d[0];

            StringBuilder bob = new StringBuilder();

            for (int j = 1; j < d.length; j++) {
                bob.append(d[j]);
                bob.append(",");

            }
            info[i] = bob.toString();
        }

        BTree iwabo = new BTree();
        for (int k = 0; k < data.length; k++) {
            iwabo.insert(Long.parseLong(data[k]));

        }
        theTree = iwabo;
    }

    public static byte[] toFormat(Node n) {
        byte[] sector = new byte[FakeDisk.getSectorSize()];
        byte[] buffer = new byte[4];
        byte[] childArray = new byte[4 * Node.getORDER()];

        for (int i = 0; i < Node.getORDER(); i++) {
            if (n.getChild(i) != null) {
                // buffer = Integer.toString(n.getChild(i).g)
            }
        }

        return buffer;
    }

    public static void writeData() {
        String filename = "btree.db";
        FakeDisk wd = new FakeDisk();
        wd.openDisk(filename, true);
        wd.clearDisk();



    }

    public static void changeOrder() throws IOException {

        System.out.print("How many children do you need? ");
        int order = getInt();
        Node.setOrder(order);

        if (order > 4) {
            theTree = new BTree();
        } else {
            theTree = new Tree234();

        }

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        theTree.insert(20);
        theTree.insert(80);
        theTree.insert(90);

    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);

    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}