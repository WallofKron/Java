package proyectosix;

/**
 * Robert Florence Professor Ferguson Spring 2013 5-21-13 Project Number 6 -
 * Comp Sci 182 - Data Structures - Create a hash table and map the collisions
 * of each individual "hash crash"
 *
 * Copyright 2005 Christopher C. Ferguson This code may only be used with the
 * permission of Christopher C. Ferguson
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeHash extends JFrame implements ActionListener {

    private static int win_xpos = 0, win_ypos = 0;// place window here
    private static int win_xsize = 700, win_ysize = 800;//  window size
    String[] names = {"fred", "barney", "tom", "jerry", "larry", "moe", "curly",
        "betty", "wilma", "bart", "homer", "marge", "maggie", "lisa",
        "pebbles", "bambam", "smithers", "burns", "milhouse", "george", "astro",
        "dino", "mickey", "minnie", "pluto", "goofy", "donald", "huey",
        "louie", "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy",
        "dopey", "sleepy", "bambi", "belle", "gaston", "tarzan", "jane",
        "simba", "scar", "mufasa", "ariel", "flounder", "bugs", "daffy",
        "elmer", "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby",
        "peggy", "spot", "pongo", "perdy", "buzz", "potatohead", "woody",
        "chuckie", "tommy", "phil", "lil", "angelica", "dill", "spike",
        "pepe", "speedy", "yosemite", "sam", "tweety", "sylvester", "granny",
        "spiderman", "batman", "superman", "supergirl", "robin", "jimmy", "olsen",
        "thing", "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman"
    };
    HashTable blah = null;
    private Font plainfont = new Font("TimesRoman", Font.PLAIN, 12);
    private JButton hashbutton, exitbutton;
    private JPanel northPanel;
    private MyJPanel centerPanel;
    private JTextField hashsizefield;
    private String thetext = "101";
    private int numb = 0;

////////////MAIN////////////////////////
    public static void main(String[] args) {
        PrimeHash tpo = new PrimeHash();
        tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

////////////CONSTRUCTOR/////////////////////
    public PrimeHash() {
        northPanel = new JPanel();
        northPanel.add(new Label("Enter a hashtable size: "));
        hashsizefield = new JTextField(thetext, 20);
        northPanel.add(hashsizefield);
        hashbutton = new JButton("CreateHash");
        northPanel.add(hashbutton);
        hashbutton.addActionListener(this);
        exitbutton = new JButton("Exit");
        northPanel.add(exitbutton);
        exitbutton.addActionListener(this);
        getContentPane().add("North", northPanel);
        centerPanel = new MyJPanel();
        getContentPane().add("Center", centerPanel);

        // need more init stuff? try here.
        setSize(win_xsize, win_ysize);
        setLocation(win_xpos, win_ypos);
        setVisible(true);
    }

////////////BUTTON CLICKS ///////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitbutton) {
            dispose();
            System.exit(0);
        }

        if (e.getSource() == hashbutton) {
            thetext = hashsizefield.getText();

            try {
                numb = Integer.parseInt(thetext);
                blah = new HashTable(numb);

            } catch (NumberFormatException ex) {
                thetext = "Not A Real Number!";
            }
            repaint();
        }
    } // end actionPerformed

    class MyJPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {

            g.setFont(plainfont);
            g.drawString("Input field contains " + thetext, 20, 30);

            try {
                if (blah != null) {
                    if (numb >= names.length) {
                        for (int i = 0; i < names.length; i++) {
                            DataItem flingdong = new DataItem(names[i]); //create DataItem

                            int shouldBe = blah.hashFunc3(names[i]); // find where it should be

                            
                            blah.insert(names[i], flingdong); // Insert to HashTable


                            // find where it actually is
                            int actual = 0;
                            for (int j = 0; j < numb; j++) {
                                if (blah.find(names[i]).getKey().equalsIgnoreCase(names[j])) {
                                    actual = shouldBe + j;
                                    break;
                                }
                                else {
                                
                                }
                            }
                            // if its not where it should be
                            if (shouldBe != actual) {
                                g.drawString("Hash Crash: " + names[i] + "\tshould be at\t" + shouldBe + " found at\t" + actual, 20, (60 + (30 * i)));
                            }
                        }
                    } else {
                        for (int i = 0; i < numb; i++) {
                            DataItem dingdong = new DataItem(names[i]);
                            blah.insert(names[i], dingdong);
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                thetext = "Not a real number";
            }

        }
    }
}