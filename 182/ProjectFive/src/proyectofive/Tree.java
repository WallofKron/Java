package proyectofive;

import java.awt.*;
import java.util.*;
/*
 * Robert Florence
 * Project 5
 * Professor Fergy Ferg
 * Spring 2013
 * 5-21-13
 * This Project creates a Binary Tree data structure and displays it in a 
 * GUI window and on the console.
 */
public class Tree {

    private Font plainfont = new Font("TimesRoman", Font.PLAIN, 12);
    private Node root;
    private String data;

    public Tree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    } //end find()

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } //end if go left?
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                } //end else go right
            } // end while
        } //end else not root
    } // end insert()

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        } //end while loop
        //found node to delete

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } //if no right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } //if no left child, replace with right subtree
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            //get successor of node to delete(current)
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            //connect successor to current's left child
            successor.leftChild = current.leftChild;

        } //end else two children
        //successor cannot have a left child
        return true;
    } //end delete()

    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("/nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("/nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("/nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            } //end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        } // end while isRowEmpty is false
        System.out.print("......................................................\n");
    } // end display tree

    public void displayTree(Graphics g, Node localTree, int x, int y, int level) {
        data = Integer.toString(localTree.iData);
        y = level * 100;
        g.drawString(data, x+7, y+18);
        g.drawOval(x, y, 30, 25);
        if (localTree.leftChild != null) {
            g.drawLine(x+10,y+25,(x-(1000/(level*4))+20), ((level+1)*100));
            displayTree(g, localTree.leftChild, x-(1000/(level*4)), y, level + 1);

        }

        if (localTree.rightChild != null) {
            g.drawLine(x+20,y+25,(x+(1000/(level*4)-10)+20), ((level+1)*100));
            displayTree(g, localTree.rightChild, x+(1000/(level*4)), y, level + 1);
        }
    }

    public Node getRoot() {
        return root;
    }
}