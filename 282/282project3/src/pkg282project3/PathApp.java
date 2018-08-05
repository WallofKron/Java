package pkg282project3;

import java.util.Scanner;
import java.io.*;

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

public class PathApp {

    static Graph theGraph = new Graph();

    public static void main(String[] args) throws IOException {
        PathApp tpo = new PathApp();
        theGraph.addVertex('A');     // 0  (start)
        theGraph.addVertex('B');     // 1
        theGraph.addVertex('C');     // 2
        theGraph.addVertex('D');     // 3
        theGraph.addVertex('E');     // 4

        theGraph.addEdge(0, 1, 50);  // AB 50
        theGraph.addEdge(0, 3, 80);  // AD 80
        theGraph.addEdge(1, 2, 60);  // BC 60
        theGraph.addEdge(1, 3, 90);  // BD 90
        theGraph.addEdge(2, 4, 40);  // CE 40
        theGraph.addEdge(3, 2, 20);  // DC 20
        theGraph.addEdge(3, 4, 70);  // DE 70
        theGraph.addEdge(4, 1, 50);  // EB 50

        System.out.println("Shortest starting paths");
        theGraph.path(0);             // shortest paths
        System.out.println();
        tpo.Menu();

    }

    public void Menu() throws IOException {
        while (true) {
            System.out.println("Enter first letter of ");
            System.out.print("Change, Add, Delete, Find, or Quit: ");
            char choice = getChar();

            switch (choice) {
                case 'c':
                    //change weight of an edge
                    changeWeight();

                    break;

                case 'a':
                    //add edge
                    addEdge(theGraph);

                    break;
                case 'd':
                    //delete edge
                    deleteEdge(theGraph);

                    break;

                case 'q':
                    //quit program
                    System.exit(0);
                    break;

                case 'f':
                    //find path
                    findpath(theGraph);

                    break;

                default:
                    System.out.print("Invalid Entry, Try Again\n");
            }
        }
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void addEdge(Graph g) throws IOException{
        Scanner input = new Scanner(System.in);

        System.out.print("Add edge from: ");
        String fromVert = getString();

        System.out.print("To: ");
        String toVert = getString();

        System.out.print("Whats the weight: ");
        int weight = input.nextInt();

        int x = lettonum(fromVert);
        int y = lettonum(toVert);

        if (g.adjMat[x][y] == theGraph.INFINITY) {
            g.adjMat[x][y] = weight;
            
        } else {
            System.out.println("Edge already exists.");
        }

    }

    public static int lettonum(String s) {
        //since input is a char, we have to convert it to the proper vertex integer code
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int num = -1;

        for (int x = 0; x < alphabet.length(); x++) {
            if (s.toLowerCase().charAt(0) == alphabet.charAt(x)) {
                num = x;
            }
        }
        return num;
    }

    public void findpath(Graph g) throws IOException {
        String startvertex;
        int a;
        System.out.print("Enter vertex you want to find: ");
        startvertex = getString();
        a = lettonum(startvertex);


        System.out.println("Shortest point from '" + startvertex + "' vertex: ");

        while (a > 0) {
        System.out.println(theGraph.vertexList[theGraph.sPath[a].parentVert].label +"\n");
            a=theGraph.sPath[a].parentVert;
        }

    }

    public static void deleteEdge(Graph g) throws IOException{
        Scanner input = new Scanner(System.in);

        System.out.print("Delete edge from: ");
        String fromVert = getString();

        System.out.print("To: ");
        String toVert = getString();

        int z = lettonum(fromVert);
        int d = lettonum(toVert);

        if (g.adjMat[z][d] == theGraph.INFINITY) {
            System.out.println("Edge does not exist.");

        } else {
            g.adjMat[z][d] = 1000000;
        }
    }

    public static String changeWeight() throws IOException {
        Scanner input = new Scanner(System.in);
        int z = 0, d = 0;
        try {
            System.out.print("Enter 'from' vertex: ");
            String fromvert = getString();

            System.out.print("\nEnter 'to' vertex: ");
            String tovert = getString();

            System.out.print("\nEnter the new weight of the edge: ");
            int newweight = input.nextInt();

            z = lettonum(fromvert);
            d = lettonum(tovert);

            if (theGraph.adjMat[z][d] == theGraph.INFINITY) {
                System.out.print("\nEdge does not exist\n\n");
            } else {
                
                theGraph.adjMat[z][d] = newweight;
                System.out.print("\nWeight on '"+fromvert+"-"+tovert+"' edge changed to "+ newweight +"\n\n");

            }
        } catch (Exception e) {
            System.out.println("Invalid Input, Try Again\n");
        }

        return null;
    }
}