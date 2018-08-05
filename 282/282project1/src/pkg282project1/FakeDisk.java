package pkg282project1;
import java.io.*;
 /*
 * Name: Robert Florence
 * Date: Oct 9, 2013 
 * Professor Ferguson
 * Java 282
 * Project #1
 * The goal this project is to create a disk based hash file database for tracking an Internet sites users
 ***************************************************
*/
public class FakeDisk {

    private static RandomAccessFile rafile;
    private int SECTORSIZE = 4096;     // size of each disksector
    private int MAXSECTORS = 256;     // max number of sectors

    public FakeDisk() {
        rafile = null;
    }

    public static boolean openDisk(String fileName, boolean createFile) {
        if (rafile != null) {
            return false;
        }  // don't open new one, make them close
        try {
            if (createFile) {
                rafile = new RandomAccessFile(fileName, "rw");
            } else {
                rafile = new RandomAccessFile(fileName, "r");
                rafile.close();
                rafile = new RandomAccessFile(fileName, "rw");
            }
            System.out.println("Fake disk drive " + fileName + " is open");
        } catch (IOException e) {
            System.out.println("Fake Disk Drive " + fileName + " is NOT open " + e.toString());
            return false;
        }
        return true;
    }

    public byte[] readSector(int sectornumber) {
        if (rafile == null) {
            return null;
        }  // not open, give them squat

        byte[] buffer = new byte[SECTORSIZE];
        try {
            rafile.seek(sectornumber * SECTORSIZE);
            int numbytes = rafile.read(buffer);
            if (numbytes == -1) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error in readSector:\n" + e.toString());
            System.exit(-1);
        }
        return buffer;  // send back the bytes
    }

    public void writeSector(int sectornumber, byte[] buffer) {
        if (rafile == null) {
            return;
        }  // not open, give them squat
        try {
            rafile.seek(sectornumber * SECTORSIZE);
            rafile.write(buffer);
        } catch (IOException e) {
            System.out.println("Error in writeSector:\n" + e.toString());
            System.exit(-1);
        }

    }

    public void clearDisk() {
        if (rafile == null) {
            return;
        }  // not open, do nothing
        byte[] buffer = new byte[SECTORSIZE];
        for (int i = 0; i < SECTORSIZE; i++) {
            buffer[i] = ' ';
        }
        for (int i = 0; i < MAXSECTORS; i++) {
            writeSector(i, buffer);
        }
    }

    public void closeDisk() {
        if (rafile == null) {
            return;
        }  // not open, give them squat

        try {
            rafile.close();
        } catch (IOException e) {
            System.out.println("Error in fake disk close:\n");
            System.exit(-1);
        }
        rafile = null;
    }
}