package pkg282project3;
/**
 * @author RobertFlorence
 *  Prof. Ferguson
 *  Comp. Sci. 282
 *  Project 3
 *  12-5-13
 *  this graphing algorithm helps solve network routing problems and helps demonstrate
 *  knowledge of basic graph algorithms by using a basic code and upgrading it
 *  to handle more functionality like adding/deleting edges, and finding the 
 *  shortest path from each vertex to all other vertices
 */

public class Vertex {

    public char label;        // label (e.g. 'A')
    public boolean isInTree;
// -------------------------------------------------------------

    public Vertex(char lab) // constructor
    {
        label = lab;
        isInTree = false;
    }
}