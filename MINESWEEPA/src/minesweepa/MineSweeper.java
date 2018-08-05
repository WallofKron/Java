package minesweepa;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/*
 * @author RobertFlorence
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@       @@@@       @@@@       @@@@       @@@@       @@@@        @@@
 * @@  @@@@   @@   @@@   @@  @@@@   @@  @@@@@  @@  @@@@   @@  @@@@@@  @@
 * @@  @@  @  @@  @@  @  @@  @@  @  @@  @@     @@  @@  @  @@    @@    @@
 * @@  @@@@@  @@ @@    @ @@  @@@@   @@  @@@@   @@  @@@@@  @@    @@    @@
 * @@  @@ @   @@  @@  @  @@  @@  @  @@  @@     @@  @@ @   @@    @@    @@
 * @@  @@  @  @@   @@@   @@  @@@@   @@  @@@@@  @@  @@  @  @@    @@    @@
 * @@@       @@@@       @@@@       @@@@       @@@@       @@@@        @@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 */
public class MineSweeper extends JFrame implements ActionListener {

    private Font regfont = new Font("TimesRoman", Font.BOLD, 15);
    private static final int vertsqs = 10;
    private static final int horzsqs = 10;
    private static int[][] board;
    private static final int SQUARE = 10;
    private static final int NO_MINE = 0;
    private static final int MINE_VAL = 101;
    private static final int NUM_MINES = 15;
    private static final int NUM_BLOCKS = vertsqs * horzsqs;
    private static int[] mineLocations = new int[NUM_BLOCKS + 1];
    private static int winxpos = 400, winypos = 120;
    private static int k = 0, temploc = 0;
    private JButton newgame, Exit;
    private JPanel northpanel, nlleft, nright, centerpanel;
    private static JFrame frame = null;
    private JTextArea minesleft, outputarea;
    private JButton[][] button = new JButton[horzsqs][vertsqs];

    public static void main(String[] args) {
        MineSweeper blah = new MineSweeper();
    }

    public MineSweeper() {
        frame = this;
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setLocation(winxpos, winypos);
        frame.setResizable(false);

        northpanel = new JPanel();
        northpanel.setBorder(BorderFactory.createLineBorder(Color.black));
        nlleft = new JPanel();
        nright = new JPanel();
        northpanel.setLayout(new GridLayout());
        northpanel.add(nlleft);
        northpanel.add(nright);

        outputarea = new JTextArea("Mines Remaining:", 1, 10);
        outputarea.setFont(regfont);
        outputarea.setOpaque(false);
        outputarea.setEditable(false);

        minesleft = new JTextArea("" + NUM_MINES, 1, 1);
        minesleft.setFont(regfont);
        minesleft.setOpaque(false);
        minesleft.setEditable(false);
        minesleft.setBorder(BorderFactory.createLineBorder(Color.black));
        
        nlleft.setBackground(Color.white);
        nlleft.setBorder(BorderFactory.createLineBorder(Color.red));
        nlleft.add(outputarea);
        nlleft.add(minesleft);


        nright.setBackground(Color.red);
        nright.setBorder(BorderFactory.createLineBorder(Color.white));
        
        newgame = new JButton("New Game");
        Exit = new JButton("Exit");
        nright.add(newgame);
        nright.add(Exit);
        newgame.addActionListener(this);
        Exit.addActionListener(this);


        centerpanel = new JPanel();
        centerpanel.setLayout(new GridLayout(10, 10));
        centerpanel.setBorder(BorderFactory.createLineBorder(Color.red));


        for (int i = 0; i < horzsqs; i++) {
            for (int j = 0; j < vertsqs; j++) {
                k++;
                button[i][j] = new JButton("" + k);
                button[i][j].addActionListener(new ButtonListener());
                centerpanel.add(button[i][j]);
            }
        }

        getContentPane().add("North", northpanel);
        getContentPane().add("Center", centerpanel);


        frame.setVisible(true);

        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        placeMines();
        printBoard();
    }

    public class ButtonListener implements ActionListener {

        ButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String checkstring = e.getActionCommand().toString();
            int check = Integer.parseInt(checkstring) - 1;
            
            if (mineLocations[check] == MINE_VAL) {
                System.out.println("BOMB!!!!!!");
            } else {
                System.out.println("SAFE!");
            }
        }
    }

    public static void printBoard() {
        for (int col = 0; col < vertsqs; col++) {
            for (int row = 0; row < horzsqs; row++) {
                System.out.print(board[row][col]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void placeMines() {
        int x2, y2;
        board = new int[horzsqs][vertsqs];

        for (int x = 0; x < horzsqs; x++) {
            for (int y = 0; y < vertsqs; y++) {
                board[x][y] = NO_MINE;
            }
        }

        for (int i = 0; i < NUM_BLOCKS; i++) {
            mineLocations[i] = 0;
        }

        Random r = new Random();

        for (int i = 0; i < NUM_MINES; i++) {
            y2 = r.nextInt(SQUARE);
            x2 = r.nextInt(SQUARE);

            if (board[x2][y2] != MINE_VAL) {
                board[x2][y2] = MINE_VAL;

                temploc = ((10 * y2) + (x2));
                mineLocations[temploc] = MINE_VAL;

            } else {
                i--;
            }
        }

        for (int col = 0; col < horzsqs; col++) {
            for (int row = 0; row < vertsqs; row++) {

                if (board[col][row] == MINE_VAL) {

                    if (row != 0) //If there is a North
                    {
                        if (!checkN(col, row)) {
                            board[col][row - 1] += 1;
                        }
                    }

                    if (row != vertsqs - 1) //if there is a South
                    {
                        if (!checkS(col, row)) {
                            board[col][row + 1] += 1;
                        }
                    }

                    if (col != horzsqs - 1) //if there is a East
                    {
                        if (!checkE(col, row)) {
                            board[col + 1][row] += 1;
                        }
                    }

                    if (col != 0) // if there is a West
                    {
                        if (!checkW(col, row)) {
                            board[col - 1][row] += 1;
                        }
                    }

                    if (col != (horzsqs - 1) && (row != 0)) //if there is a NorthE
                    {
                        if (!checkNE(col, row)) {
                            board[col + 1][row - 1] += 1;
                        }
                    }

                    if (col != 0 && row != 0) // NorthW
                    {
                        if (!checkNW(col, row)) {
                            board[col - 1][row - 1] += 1;
                        }
                    }

                    if (row != vertsqs - 1 && col != horzsqs - 1) // SouthE
                    {
                        if (!checkSE(col, row)) {
                            board[col + 1][row + 1] += 1;
                        }
                    }

                    if (row != vertsqs - 1 && col != 0) // SouthW
                    {
                        if (!checkSW(col, row)) {
                            board[col - 1][row + 1] += 1;
                        }
                    }
                }
            }
        }
    }

    private static boolean checkN(int col, int row) {
        if (board[col][row - 1] == MINE_VAL) {
            return true;
        }
        return false;
    }

    private static boolean checkE(int col, int row) {
        if (board[col + 1][row] == MINE_VAL) {
            return true;
        }
        return false;
    }

    private static boolean checkS(int col, int row) {
        if (board[col][row + 1] == MINE_VAL) {
            return true;
        }
        return false;
    }

    private static boolean checkW(int col, int row) {
        if (board[col - 1][row] == MINE_VAL) {
            return true;
        }
        return false;
    }

    private static boolean checkNE(int col, int row) {
        if (board[col + 1][row - 1] == MINE_VAL) {
            return true;
        }
        return false;
    }

    private static boolean checkNW(int col, int row) {
        if (board[col - 1][row - 1] == MINE_VAL) {
            return true;
        }
        return false;
    }

    private static boolean checkSE(int col, int row) {
        if (board[col + 1][row + 1] == MINE_VAL) {
            return true;
        }
        return false;
    }

    private static boolean checkSW(int col, int row) {
        if (board[col - 1][row + 1] == MINE_VAL) {
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Exit) {
            dispose();
            System.exit(0);
        }

        if (e.getSource() == newgame) {
            placeMines();
            printBoard();

        }
    }
}