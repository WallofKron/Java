package pictureviewer;

import java.awt.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

/**
 * @author Robert Florence Sept 18th, 2012 CS111 lab Project 3 A simple Picture
 * viewer
 *
 */
public class PictureViewer {

    final static int MIN_NUMBER = 1;
    final static int MAX_NUMBER = 8;
    static int image_number = 1;
    static String fileName = "";
    static boolean windowCreated = false;
    static JFrame frame1;
    static Image theImage;

    public static int forward(int current_number) {
        if (current_number >= MAX_NUMBER) {
            current_number = MIN_NUMBER;
        } else {
            current_number++;
        }
        return current_number;
    }

    public static int backward(int current_number) {
        if (current_number > MIN_NUMBER) {
            current_number--;
        }
        return current_number;
    }

    public static String createFileName(int current_number) {
        String X = Integer.toString(current_number);
        String newFileName = "Picture" + X + ".gif";
        fileName = newFileName;
        return newFileName;
    }

    public static String createRandomName() {
        Random rand = new Random();
        int rumnum = 1 + rand.nextInt(8);
        String Y = Integer.toString(rumnum);
        String newFileName = "Picture" + Y + ".gif";
        fileName = newFileName;
        return newFileName;
    }

    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        PictureViewer pv = new PictureViewer();
        int menu = -1;
        while (menu != 0) {

            System.out.println("Current Number is: " + image_number);
            System.out.println("-Menu-\n1. Forward\n2. Backward\n3. Create File Name\n4. Create Random Name\n5. Show Window"
                    + "\n6. Overload Forward\n7. Overload Backward\n8. Use Any Filename");
            menu = input.nextInt();

            switch (menu) {

                case 1:// forward
                    image_number = forward(image_number);
                    break;

                case 2:// backward
                    image_number = backward(image_number);
                    break;

                case 3:// createfilename
                    System.out.println("The File Name is: "
                            + createFileName(image_number));
                    break;

                case 4:// createrandomname
                    System.out.println("The File Name is: " + createRandomName());
                    break;

                case 5:// ShowWindow
                    showWindow(fileName);
                    break;

                case 6:// overloadforward
                    pv.forward();
                    break;

                case 7:// overloadbackward
                    pv.backward();
                    break;

                case 8://getanyfile

                    break;
                default:
                    menu = 0;
            }
        }
    }

    public static void showWindow(String fileName) {
        MyPanel mp = new MyPanel();
        PictureViewer pv = new PictureViewer();
        if (!windowCreated) {
            frame1 = new JFrame();
            frame1.setTitle(fileName);
            frame1.setSize(350, 350);
            frame1.setLocation(300, 200);
            frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            theImage = pv.load_picture(fileName, frame1);
            frame1.add(mp);
            frame1.setVisible(true);
            windowCreated = true;
        } else {
            frame1.setVisible(true);
            theImage = pv.load_picture(fileName, frame1);
            frame1.repaint();
            frame1.setTitle(fileName);
            frame1.setAlwaysOnTop(true);
            frame1.setAlwaysOnTop(false);
        }
    }

    public void forward() {
        if (image_number >= MAX_NUMBER) {
            image_number = MIN_NUMBER;
        } else {
            image_number++;
        }
    }

    public void backward() {
        if (image_number > MIN_NUMBER) {
            image_number--;
        }
    }
    
    public Image load_picture(String imagefile, JFrame theframe) {
        Image tempimage;
        MediaTracker tracker;
        tracker = new MediaTracker(theframe);

        String startURL;
        if (imagefile.startsWith("http")) {
            startURL = "";
        } else {
            startURL = "http://www.canyons.edu/departments/comp_sci/ferguson/cs111/images/";
        }
        URL myURL = null;
        try {
            myURL = new URL(startURL + imagefile);
        } catch (MalformedURLException e) {
            System.out.println("Error caught " + e.toString());
        }
        tempimage = Toolkit.getDefaultToolkit().getImage(myURL);
        tracker.addImage(tempimage, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException err) {
            System.err.println(err);
        }
        return tempimage;
    }

    public static void main(String[] args) {
        showMenu();
    }

    public static class MyPanel extends JPanel {

        public void paintComponent(Graphics g) {
            int xpos, ypos;
            super.paintComponent(g);
            xpos = 10;
            ypos = 10;
            if (theImage != null) {
                g.drawImage(theImage, xpos, ypos, this);
            }
        }
    }
}