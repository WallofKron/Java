package project2;
import java.util.Scanner;
/**
 *@author Robert Florence
 * Sept 18th, 2012
 * CS111 lab 
 * Project 2 Part 1
 * User inputs grades into a grade book and outputs averages and letter grades
 * 
 */
public class Project2 {
   public static void main(String[] args) {
   
       Scanner Robert = new Scanner(System.in);
       
       double score, total, average;
       char grade, avgrade;
       int as = 0, bs= 0, cs = 0, ds = 0, fs = 0;
       int scorecounter = -1;
      total = 0;
      
       System.out.println("Enter Test Scores into gradebook, and Enter '-1' when finished\n");
      
       do { 
           System.out.print("Enter Test Score: ");
           score = Robert.nextDouble();
       
           if (score >= 90) {
               grade = 'A';
           as++;
           }
           else if (score >= 80) {
               grade = 'B';
           bs++;
           }
           else if (score >= 70) {
               grade = 'C';
           cs++;
           }     
           else if (score >= 60) {
               grade = 'D';
           ds++;
           }     
           else {grade = 'F';
           fs++;
           }
           
           scorecounter++;
           
          if (score != -1){
           System.out.println("The Score " + score + " is an " + grade);
          }
          
          total = total + score;
          
       }  while (score !=-1);
       
          Robert.close();
       
       total++;
       fs--;
       average = total/scorecounter;
       
       if (average >= 90) {
              avgrade = 'A';}
         else if (average >= 80) {
               avgrade = 'B';}
         else if (average >= 70) {
               avgrade = 'C';}
         else if (average >= 60) {
               avgrade = 'D';}
         else  {avgrade = 'F';}
           
       System.out.println("\nAmount of scores: " + scorecounter);
       System.out.println("Total Points: " + total);
       System.out.println("Average Score: " + average);
       System.out.println("Average Class Grade: " + avgrade);
       System.out.println("Amount of A's: " + as);
       System.out.println("Amount of B's: " + bs);
       System.out.println("Amount of C's: " + cs);
       System.out.println("Amount of D's: " + ds);
       System.out.println("Amount of F's: " + fs);
         }
       }