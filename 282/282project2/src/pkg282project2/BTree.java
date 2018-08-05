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
public class BTree extends Tree234 {

    public void split(Node thisNode) {

        int topHalf = ((int) Math.ceil(((double) thisNode.getORDER() - 1) / 2)) - 1;

        DataItem itemB;
        DataItem[] itemCA = new DataItem[topHalf];
        Node[] childHalf = new Node[topHalf + 1];
        Node parent;
        int itemIndex;

        for (int i = 0; i < topHalf; i++) {
            itemCA[i] = thisNode.removeItem();
        }
        itemB = thisNode.removeItem();
        //Remove all the items above middle item, then remove mid

        int childNum = thisNode.getORDER() - (topHalf + 1);
        for (int i = 0; i <= topHalf; i++) {
            childHalf[i] = thisNode.disconnectChild(childNum++);
        }


        Node newRight = new Node();       // make new node

        if (thisNode == root) // if this is the root,
        {
            root = new Node();                // make new root
            parent = root;                    // root is our parent
            root.connectChild(0, thisNode);   // connect to parent
        } else // this node not the root
        {
            parent = thisNode.getParent();    // get parent
        }
        // deal with parent
        itemIndex = parent.insertItem(itemB); // item B to parent
        int n = parent.getNumItems();         // total items?

        for (int j = n - 1; j > itemIndex; j--) // move parent's
        {                                      // connections
            Node temp = parent.disconnectChild(j); // one child
            parent.connectChild(j + 1, temp);        // to the right
        }
        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        // deal with newRight

        for (int i = 0; i < topHalf; i++) {
            newRight.insertItem(itemCA[i]);
            newRight.connectChild(i, childHalf[i]);
        }
        newRight.connectChild(topHalf, childHalf[topHalf]);
        //Connect all the children back from the array
    }
}