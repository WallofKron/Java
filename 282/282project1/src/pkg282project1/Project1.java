package pkg282project1;

import java.io.*;
/**
 * *****************************************************
 * Project #1 - Starter code Command Line Interface version Hash disk file
 * project copyright 2004 Christopher C.Ferguson
 *
 * Name: Robert Florence Date: Oct 9, 2013 Professor Ferguson Java 282 Project
 * #1 The goal this project is to create a disk based hash file database for
 * tracking an Internet sites users
 * **************************************************
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Project1 {

    public static final int RECORDSIZE = 512;
    public static final int SECTORSIZE = 4096;
    public static final int NUMSECTORS = 256;
    public static final int HASHSIZE = 1001;
    public static final int BUCKETSIZE = 4;
    private MyRecord[] bucket;
    private FakeDisk theDisk = null;
    private static boolean openflag = true;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Project1 tpo = new Project1();
        while (openflag == true) {
            tpo.showMenu();
        }
    }

    private void showMenu() {
        int user = 0;
        System.out.print("1).Open DB  2). View a bucket  3).Close DB  4).Import a file  5).Exit\n");
        System.out.print("Enter a Command: ");
        if (input.hasNextInt()) {
            user = input.nextInt();
            userinput(user);
        } else {
            System.out.println("Incorrect Option: ");
            openflag = false;
        }
    }

    private void toHash() throws FileNotFoundException {
        int NUMSECTORS = 250;
        System.out.print("Hash File Name: ");
        theDisk.openDisk(new Scanner(System.in).next(), true);
        Scanner input = new Scanner(new File("data.txt"));
        String[][] hash = new String[NUMSECTORS][8];
        while (input.hasNext()) {
            String s = input.nextLine();
            int record = -1, sector = hashFunc3(s.substring(0, s.indexOf(",")));
            do {


                if (hash[sector][++record] != null) {
                    hash[sector][record] = s;
                }

            } while (hash[sector][record] != null);


        }
    }

    private void openDbFile(Scanner input) {
        System.out.print("Enter name of the file to open: ");
        String fname = input.nextLine();
        theDisk = new FakeDisk();

        if (theDisk.openDisk(fname, false) == false) {
            openDbFile(input);
        }
    }

    private void openSector(Scanner input) {
        System.out.print("Enter the number of the sector to open: ");
        int sectornumber = input.nextInt();

        byte[] sector = theDisk.readSector(sectornumber);
        while (sector == null) // keep reading till correct sector
        {
            System.out.println("Sector Error.");
            System.out.print("Enter the number of the sector to open: ");
            sectornumber = input.nextInt();
            sector = theDisk.readSector(sectornumber);
        }
        String stringsector = new String(sector);	// convert byte array to string

        int x = 0, y = 0, i = 0;
        System.out.println();
        while (x < stringsector.length()) {	// loop through and get each sector
            i++;
            y = x + 511;
            if (y < stringsector.length()) {
                System.out.println(i + ": " + stringsector.substring(x, y).trim());
            }
            x += 511;
        }
        System.out.println();
    }

    private boolean toRecord(int Bucketnum) {
        bucket = new MyRecord[8];
        if (theDisk.readSector(Bucketnum) != null) {

            byte[] j = theDisk.readSector(Bucketnum - 1);

            for (int i = 0; i < 8; i++) {
                String buffer = new String(Arrays.copyOfRange(j, (i * RECORDSIZE), (((i + 1) * RECORDSIZE) - 1)));

                if (buffer.charAt(0) != ' ') {

                    String[] sBuffer = buffer.split("\\,");

                    //bucket[i] = new MyRecord(sBuffer[0].trim(), sBuffer[1].trim(), sBuffer[2].trim(), sBuffer[3].trim(), sBuffer[4].trim());
                } else {
                    bucket[i] = new MyRecord();
                }
            }
            return true;

        } else {
            return false;
        }
    }

    private void closeDbFile() {
        System.out.println("File closed\n");
        theDisk.closeDisk();	// close the FakeDisk object	
    }

    private void importDbFile(Scanner input) {
        theDisk = new FakeDisk();

        System.out.print("Enter name of new file: ");
        String fname = input.nextLine();	// input file name

        theDisk.openDisk(fname, true);
        theDisk.clearDisk();	// clear the disk with empty buckets

        int hash;		// holds the sector number generated from the hashFunc3()
        String[] sector = new String[NUMSECTORS];	// hold each of the sectors
        File file = new File("data.txt");

        try {

            for (int i = 0; i < NUMSECTORS; i++) {	// make sure its not null
                sector[i] = "";
            }

            Scanner scanner = new Scanner(file);	// load data.txt file
            while (scanner.hasNextLine()) {	// read through data.txt
                String line = scanner.nextLine();
                String email = line.substring(0, line.indexOf(","));	// holds the email address
                hash = this.hashFunc3(email);	// hash the email address

                while (line.length() < RECORDSIZE) {	// add extra bytes to the record
                    line += " ";
                }
                while (sector[hash].length() == SECTORSIZE) // if full
                {
                    hash++;
                }
                sector[hash] += line;
            }

            for (int i = 0; i < sector.length; i++) {
                theDisk.writeSector(i, sector[i].getBytes());
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File error.");
        }
    }

    private void exitProgram() {
        System.out.println("Program exited\n");
        System.exit(0);
    }

    private void userinput(int command) {
        Scanner input = new Scanner(System.in);
        switch (command) {
            case 1:
                openDbFile(input);
                break;
            case 2:
                openSector(input);
                break;
            case 3:
                closeDbFile();
                break;
            case 4:
                importDbFile(input);
                break;
            case 5:
                exitProgram();
                break;
            default:
                System.out.println("Enter a valid choice.");
        }
    }

    private int hashFunc3(String key) {	// returns sector number
        int hashval = 0;
        for (int j = 0; j < key.length(); j++) {
            int letter = key.charAt(j) - 96;
            if (letter > 0) {
                hashval = (hashval * 27 + letter) % HASHSIZE;
            }
        }
        return hashval / BUCKETSIZE;
    }
}