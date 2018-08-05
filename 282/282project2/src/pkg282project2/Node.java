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
class Node {

    private static int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;

        if (child != null) {
            child.parent = this;
        }

    }

    // disconnect child from this node, return it 
    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;

    }

    public static int getORDER() {
        return ORDER;
    }

    public static void setOrder(int order) {

        ORDER = order;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {

        return (childArray[0] == null) ? true : false;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) { // get DataItem at index
        return itemArray[index];
    }

    public boolean isFull() {
        return (numItems == ORDER - 1) ? true : false;
    }

    //  ------------------------------------------------------------- 
    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } // return index of // item (within node) // if found, // otherwise, // return -1
            else if (itemArray[j].dData == key) {
                return j;
            }
        }
        return -1;
    } // end findItem

    public int insertItem(DataItem newItem) {
        // assumes node is not full 
        numItems++;
        long newKey = newItem.dData;

        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] == null) {
                continue;
            } else {
                long itsKey = itemArray[j].dData;
                if (newKey < itsKey) {
                    itemArray[j + 1] = itemArray[j];
                } else {
                    // will add new item key of new item
                    // start on right, examine items
                    // if item null, go left one cell not null, get its key
                    //if it’s bigger // shift it right
                    itemArray[j + 1] = newItem; // insert new item
                    return j + 1;
                } // end else (not null)
            } // end for 
        } // end insertItem()
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {

        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

// disconnect it // one less item // return item
// -------------------------------------------------------------
    public void displayNode() {
        for (int j = 0; j < numItems; j++) {
            itemArray[j].displayItem();
        }
        System.out.println("/");
// format “/24/56/74/”
// “/56” // final “/”
    }
}