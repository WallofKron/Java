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
public class FakeDisk {

    private static RandomAccessFile rafile;
    private static int SECTORSIZE = 4096;     // size of each disksector
    private int MAXSECTORS = 256;     // max number of sectors

    public FakeDisk() {
        rafile = null;
    }

    public static int getSectorSize() {
        return SECTORSIZE;
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