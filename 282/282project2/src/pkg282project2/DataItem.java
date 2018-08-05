package pkg282project2;

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
public class DataItem {

    public long dData;
    public String record;

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public DataItem(long dd) { // constructor  
        dData = dd;
    }

    public void displayItem() { // display item, format “/27”
        System.out.print("/" + dData);
    }
}