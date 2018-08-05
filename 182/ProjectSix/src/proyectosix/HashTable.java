package proyectosix;
/**
 * Robert Florence Professor Ferguson Spring 2013 5-21-13 Project Number 6 -
 * Comp Sci 182 - Data Structures - Create a hash table and map the collisions 
 * of each individual "hash crash"
 * 
 * Copyright 2005 Christopher C. Ferguson This code may only be used with the
 * permission of Christopher C. Ferguson
 */
class DataItem {

    private String iData; // data item (key)

//--------------------------------------------------------------
    public DataItem(String ii) { // constructor

        iData = ii;
    }

//-------------------------------------------------------------- 
    public String getKey() {
        return iData;
    }
//--------------------------------------------------------------
} // end class DataItem

public class HashTable {

    private DataItem[] hashArray;   //array is the has table
    private int arraySize;
    private DataItem nonItem;       //for delted items

//-------------------------------------------------------------- 
    HashTable(int size) {   //constructor
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem("-1");
    }

//--------------------------------------------------------------   
    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
            System.out.println("");
        }
    }

//--------------------------------------------------------------    
    public int hashFunc1(int key) {
        return key % arraySize;
    }

//-------------------------------------------------------------- 
    public int hashFunc2(String key) {
        //non-zero, less than array size, different from hF1
        //array size must be relatively prime to 5, 4, 3, and 2
        return 5 - hashFunc3(key) % 5;
    }

//-------------------------------------------------------------- 
    public int hashFunc3(String key) {
        int hashVal = 0;
        for (int j = 0; j < key.length(); j++) {                  //left to right
            int letter = key.charAt(j) - 96;                //get char code
            hashVal = (hashVal * 27 + letter) % arraySize;  //mod
        }
        return hashVal;                                     //no mod
    }   //end hashFunc3

//--------------------------------------------------------------     
    // insert a DataItem
    public void insert(String key, DataItem item) {
        // (assumes table not full)
        int hashVal = hashFunc3(key);   //hash the key
        int stepSize = hashFunc2(key);  //get step size
        // until empty cell or -1
        while (hashArray[hashVal] != null){// || !hashArray[hashVal].getKey().equalsIgnoreCase("-1")) {
            hashVal += stepSize;        //add the step
            hashVal %= arraySize;       //for wraparound
        }
        hashArray[hashVal] = item;      //insert item
    }   //end insert()

//-------------------------------------------------------------- 
    public DataItem delete(String key) {           //delete a DataItem
        int hashVal = hashFunc3(key);           //hash the key
        int stepSize = hashFunc2(key);          //get step size

        while (hashArray[hashVal] != null) {     //until empty cell,
            if (hashArray[hashVal].getKey().equalsIgnoreCase(key)) {
                DataItem temp = hashArray[hashVal];     //save item
                hashArray[hashVal] = nonItem;           //delete item
                return temp;                            //return item
            }
            hashVal += stepSize;                        //add the step
            hashVal %= arraySize;                       //for wraparound
        }
        return null;                                    //can't find item
    }   //end delete()

//--------------------------------------------------------------
    public DataItem find(String key) {                //find item with key
        // (assumes table not full)    
        int hashVal = hashFunc3(key);               //hash the key
        int stepSize = hashFunc2(key);              //get step size

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey().equalsIgnoreCase(key)) {
                return hashArray[hashVal];          //yes, return item
            }
            hashVal += stepSize;                    //add the step
            hashVal %= arraySize;                   //for wraparound

        }
        return null;
    }
}