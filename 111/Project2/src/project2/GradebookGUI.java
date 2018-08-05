package project2;
import javax.swing.JOptionPane;
/**
 * 
 *@author Robert Florence
 * Sept 18th, 2012
 * CS111 lab 
 * Project 2 Part 2
 * User inputs grades into a grade book and it outputs grade averages and letter grades
 * 
 */
public class GradebookGUI {
    public static void main(String[] args) {
     
       JOptionPane.showMessageDialog(null, "*-Gradebook-*\n \nPress 'Ok' to continue","GradeBook 1.0" , JOptionPane.INFORMATION_MESSAGE);
     
       double fgrades, total = 0, average;
       char grade, avgrade;
       int as = 0, bs= 0, cs = 0, ds = 0, fs = 0;
       int scorecounter = 0;
       
       do {  
           String grades = JOptionPane.showInputDialog(null, "Enter Grades: \n\nEnter '-1' when finished entering grades", "GradeBook 1.0", JOptionPane.QUESTION_MESSAGE);
           fgrades = Double.parseDouble(grades);
           
           if (fgrades >= 90) {
               grade = 'A';
           as++;
           }
           else if (fgrades >= 80) {
               grade = 'B';
           bs++;
           }
           else if (fgrades >= 70) {
               grade = 'C';
           cs++;
           }     
           else if (fgrades >= 60) {
               grade = 'D';
           ds++;
           }     
           else {grade = 'F';
           fs++;
           }
           
           scorecounter++;
           
          if (fgrades != -1){
        JOptionPane.showMessageDialog(null, "The Score " + fgrades + " is an " + grade);
          }
          
          total = total + fgrades;
          
       }  while (fgrades !=-1);
       
       scorecounter--;
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
           
       JOptionPane.showMessageDialog(null, "Results:" + "\n\nAmount of scores: " + scorecounter + "\nAverage Score: " + average + 
      "\nAverage Class Grade: " + avgrade + "\n# of A's: " + as + "\n# of B's: " + bs + "\n# of C's: " + cs + "\n# of D's: " + ds + 
         "\n# of F's: " + fs,"GradeBook 1.0" , JOptionPane.INFORMATION_MESSAGE);
         }
       }