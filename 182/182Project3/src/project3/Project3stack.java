package project3;

import java.awt.event.*;
import java.util.Stack;
import javax.swing.*;

/**
 * @author RobertFlorence 
 * Project 3 - Stack Game - a game in which you try to help kirk find his
 * muy mas macho by popping and pushing onto a stack to jump from 'moon to moon' 
 * CS 182 - Ferguson 
 * April 2013
 */

public final class Project3stack extends JFrame implements ActionListener {

    private static int xpos = 100, ypos = 100;// place window at this position
    private Stack<Moon> thestack = new Stack<Moon>();
    private static int xsize = 850, ysize = 500;// set window to this size
    private JPanel northPanel, centerPanel;
    private JButton pushButton, popButton, dumpButton, exitButton;
    private JTextField moonField;
    private JTextField codeField;
    private JTextArea outputArea;
    private static Moon Rhea, Titan, Elara, Io, Enterprise, Europa, Metis, currentmoon;
    private boolean gotorb = false;

    public static void main(String[] args) {
        init();
        Project3stack tpo = new Project3stack();
    }

    public Project3stack() {
        addScreenComponents();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(xsize, ysize);
        setLocation(xpos, ypos);
        setVisible(true);
    }

    public static void init() {
        Rhea = new Moon("Rhea", null);
        Enterprise = new Moon("Enterprise", "1234");
        Titan = new Moon("Titan", null);
        Io = new Moon("Io", null);
        Europa = new Moon("Europa", null);
        Elara = new Moon("Elara", null);
        Metis = new Moon("Metis", null);

        currentmoon = Enterprise;
    }

    public boolean mooncheck(Moon currentmoon, Moon nextMoon) {

        if (currentmoon == Enterprise) {
            if (nextMoon == Titan || nextMoon == Rhea || nextMoon == Europa) {
                return true;
            }
        }
        if (currentmoon == Rhea) {
            if (nextMoon == Titan || nextMoon == Enterprise || nextMoon == Europa) {
                return true;
            }
        }
        if (currentmoon == Titan) {
            if (nextMoon == Enterprise || nextMoon == Rhea || nextMoon == Elara) {
                return true;
            }
        }
        if (currentmoon == Europa) {
            if (nextMoon == Metis || nextMoon == Rhea || nextMoon == Enterprise) {
                return true;
            }
        }
        if (currentmoon == Elara) {
            if (nextMoon == Titan || nextMoon == Metis) {
                return true;
            }
        }
        if (currentmoon == Metis) {
            if (nextMoon == Elara || nextMoon == Europa || nextMoon == Io) {
                return true;
            }
        }
        if (currentmoon == Io) {
            if (nextMoon == Metis) {
                return true;
            }
        }

        return false;
    }

    public void addScreenComponents() {
        northPanel = new JPanel();
        northPanel.add(new JLabel("Enter A moon name: "));
        moonField = new JTextField("", 15);
        northPanel.add(moonField);
        northPanel.add(new JLabel("And A Code: "));
        codeField = new JTextField("", 5);
        northPanel.add(codeField);

        pushButton = new JButton("Push");
        northPanel.add(pushButton);
        pushButton.addActionListener(this);
        popButton = new JButton("Pop");
        northPanel.add(popButton);
        popButton.addActionListener(this);
        dumpButton = new JButton("Dump");
        northPanel.add(dumpButton);
        dumpButton.addActionListener(this);
        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);

        getContentPane().add("North", northPanel);

        centerPanel = new JPanel();
        outputArea = new JTextArea("Space, the final frontier.... To boldly go find my Muy Mas Macho!\n\n\nRemember, You start on The Enterprise with code 1234", 27, 58);
        centerPanel.add(outputArea);
        getContentPane().add(centerPanel, "Center");

    }

    public void Die() {
        outputArea.setText("You failed at life and are now dead.....\n\n Restarting at The Enterprise");
        restart();
    }

    public void restart() {
        while (!thestack.empty()) {
            thestack.pop();

        }
        currentmoon = Enterprise;
        pushButton.setEnabled(true);
    }

    public Moon moonnamecheckerer(String newmoon) {
        if (newmoon.equalsIgnoreCase(Enterprise.getName())) {
            return Enterprise;
        }
        if (newmoon.equalsIgnoreCase(Rhea.getName())) {
            return Rhea;
        }
        if (newmoon.equalsIgnoreCase(Titan.getName())) {
            return Titan;
        }
        if (newmoon.equalsIgnoreCase(Europa.getName())) {
            return Europa;
        }
        if (newmoon.equalsIgnoreCase(Io.getName())) {
            return Io;
        }
        if (newmoon.equalsIgnoreCase(Elara.getName())) {
            return Elara;
        }
        if (newmoon.equalsIgnoreCase(Metis.getName())) {
            return Metis;
        }

        return null;
    }

    public void dump() {
        Stack<Moon> newstack = new Stack<Moon>();
        while (!thestack.empty()) {
            Moon tempmoon = thestack.pop();
            System.out.println(tempmoon.getName() + ", " + tempmoon.getPasscode());
            newstack.push(tempmoon);

        }
        System.out.println("\n");
        while (!newstack.empty()) {
            thestack.push(newstack.pop());
        }
    }

    public boolean checkNumber(String s) {

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }

        if (e.getSource() == popButton) {
            String newmoon = moonField.getText();
            String newcode = codeField.getText();
            if (!thestack.empty()) {
                if (newcode.equalsIgnoreCase(thestack.peek().getPasscode()) && newmoon.equalsIgnoreCase(thestack.peek().getName())) {
                    currentmoon = thestack.pop();
                    outputArea.setText("Pop returning to " + newmoon);


                    if (currentmoon == Enterprise) {

                        if (gotorb) {
                            outputArea.setText("You Win! \n\n\n Restarting!");
                            restart();
                        }
                    }
                } else {
                    Die();

                }

            }

        }

        if (e.getSource() == pushButton) {
            String newmoon = moonField.getText();
            String newcode = codeField.getText();

            if (newmoon == null || newcode.length() != 4 || newcode.equalsIgnoreCase(currentmoon.getPasscode()) || !checkNumber(newcode)) {
                outputArea.setText("Error with moon name or password");
            } else {
                Moon tempmoon = moonnamecheckerer(newmoon);
                if (tempmoon != null && mooncheck(currentmoon, tempmoon)) {
                    tempmoon.setPasscode(newcode);
                    thestack.push(currentmoon);
                    currentmoon = tempmoon;
                    outputArea.setText("Push entering " + newmoon);
                    if (currentmoon == Io) {
                        gotorb = true;
                        outputArea.append("\n\nKirk has the Orb");

                        pushButton.setEnabled(false);
                    }
                } else {
                    outputArea.setText("Cannot get to that moon!");
                }
            }

        }

        if (e.getSource() == dumpButton) {
            System.out.println("Stack Contents Dump: ");
            dump();

        }

    }
}