package proyectofive;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Robert Florence
 * Project 5
 * Professor Fergy Ferg
 * Spring 2013
 * 5-21-13
 * This Project creates a Binary Tree data structure and displays it in a 
 * GUI window and on the console.
 */
public class BinaryTree extends JFrame implements ActionListener {

    private static int winxpos = 0, winypos = 0;
    private Font boldfont = new Font("TimesRoman", Font.BOLD, 18);
    private Font plainfont = new Font("TimesRoman", Font.PLAIN, 12);
    private JButton insertbutton, exitbutton;
    private JTextField infield;
    private JPanel northPanel;
    private MyPanel centerPanel;
    private static final int WINWIDTH = 1200;
    private static final int WINHEIGHT = 900;
    private Tree theTree = new Tree();

    public static void main(String[] args) {
        BinaryTree tpo = new BinaryTree();

        tpo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static int getWINWIDTH() {
        return WINWIDTH;
    }

    
    public BinaryTree() {
        northPanel = new JPanel();
        northPanel.add(new Label("Enter a number to insert: "));
        infield = new JTextField("", 20);
        northPanel.add(infield);
        insertbutton = new JButton("Insert");
        northPanel.add(insertbutton);
        insertbutton.addActionListener(this);
        exitbutton = new JButton("Exit");
        northPanel.add(exitbutton);
        exitbutton.addActionListener(this);
        getContentPane().add("North", northPanel);

        centerPanel = new MyPanel();
        getContentPane().add("Center", centerPanel);

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);

        setSize(WINWIDTH, WINHEIGHT);
        setLocation(winxpos, winypos);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitbutton) {
            dispose();
            System.exit(0);

        }

        if (e.getSource() == insertbutton) {

            theTree.insert(Integer.parseInt(infield.getText()), 2.1);

            repaint();
        }
    }

    
    class MyPanel extends JPanel {

        ////////////    PAINT   //////////////////////////////// 
        @Override
        public void paintComponent(Graphics g) {
            theTree.displayTree();
            theTree.displayTree(g, theTree.getRoot(), WINWIDTH / 2, 100, 1);

        }
    }
}