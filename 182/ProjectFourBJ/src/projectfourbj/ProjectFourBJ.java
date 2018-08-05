package projectfourbj;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class ProjectFourBJ extends JFrame implements ActionListener {

    private Font regfont = new Font("TimesRoman", Font.PLAIN, 22);
    private Font boldfont = new Font("TimesRoman", Font.ITALIC, 30);
    private DecimalFormat f = new DecimalFormat("#.##");
    private static int winxpos = 200, winypos = 30, pmoney, curbet;
    private final static int maxbet = 100;
    private static double bjwin = 0;
    private JButton dealButton, exitButton, newButton, hitButton, standButton, doubledown, NewBet, oneButt, fiveButt, tenButt, twentyButt, fiftyButt;
    private CardList theDeck = null;
    private CardList playerH = null;
    private CardList dealerH = null;
    private static double handsplayed, wincount, loss = 0;
    private JPanel northPanel, southPanel, eastPanel, southleft, southright;
    private JTextArea textArea, outputArea;
    private MyPanel centerPanel;
    private static JFrame myFrame = null;
    private Card cardback;
    private boolean dubdown;

    public static void main(String[] args) {
        ProjectFourBJ tpo;
        tpo = new ProjectFourBJ();
    }

    public ProjectFourBJ() {
        myFrame = this;
        textArea = new JTextArea("~Stats~", 1, 9);
        textArea.setFont(new Font("Arial", Font.BOLD, 24));
        textArea.setOpaque(false);
        eastPanel = new JPanel();
        eastPanel.setBackground(Color.LIGHT_GRAY);
        eastPanel.add(textArea);

        southPanel = new JPanel();
        southleft = new JPanel();
        southright = new JPanel();
        southPanel.setLayout(new GridLayout(1, 1));
        southPanel.add(southleft);
        southPanel.add(southright);
        southleft.setBackground(Color.red);
        southright.setBackground(Color.red);

        outputArea = new JTextArea("", 1, 1);
        outputArea.setFont(new Font("Arial", Font.BOLD, 35));
        outputArea.setOpaque(false);

        NewBet = new JButton("Reset Bet");
        southleft.add(NewBet);
        NewBet.addActionListener(this);

        oneButt = new JButton("$1");
        southleft.add(oneButt);
        oneButt.addActionListener(this);

        fiveButt = new JButton("$5");
        southleft.add(fiveButt);
        fiveButt.addActionListener(this);

        tenButt = new JButton("$10");
        southleft.add(tenButt);
        tenButt.addActionListener(this);

        twentyButt = new JButton("$20");
        southleft.add(twentyButt);
        twentyButt.addActionListener(this);

        fiftyButt = new JButton("$50");
        southleft.add(fiftyButt);
        fiftyButt.addActionListener(this);
        
        southright.add(outputArea);

        northPanel = new JPanel();
        northPanel.setBackground(Color.black);
        newButton = new JButton("New Deck");
        northPanel.add(newButton);
        newButton.addActionListener(this);

        dealButton = new JButton("Deal");
        northPanel.add(dealButton);
        dealButton.addActionListener(this);

        hitButton = new JButton("Hit");
        northPanel.add(hitButton);
        hitButton.addActionListener(this);

        standButton = new JButton("Stand");
        northPanel.add(standButton);
        standButton.addActionListener(this);

        doubledown = new JButton("Double Down");
        northPanel.add(doubledown);
        doubledown.addActionListener(this);

        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);

        centerPanel = new MyPanel();
        getContentPane().add("North", northPanel);
        getContentPane().add("South", southPanel);
        getContentPane().add("East", eastPanel);
        getContentPane().add("Center", centerPanel);

        theDeck = new CardList(52);
        playerH = new CardList(0);
        dealerH = new CardList(0);
        cardback = new Card(0);

        javax.swing.JLabel backround = new javax.swing.JLabel();
        setSize(1100, 850);
        setLocation(winxpos, winypos);

        setVisible(true);
        
        dealButton.setEnabled(false);
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        doubledown.setEnabled(false);

        backround.setIcon(new ImageIcon(load_picture("cards/greenfelt.jpg")));
        backround.setOpaque(true);
        getContentPane().add(backround);
        backround.setBounds(0, 0, 400, 280);
        
        repaint();
        disablebetbutts();
        outputArea.setText("Click 'New Deck' to Start Game");
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);

        }
        if (e.getSource() == NewBet) {
            if (curbet == 0) {
                outputArea.setText("Bet already at 0");
            } else {
                outputArea.setText("Bet Reset to 0");
                curbet = 0;
                repaint();
            }
            enablebetbutts();
        }
        if (e.getSource() == oneButt) {

            if (curbet != maxbet) {
                curbet = curbet + 1;
                dealButton.setEnabled(true);
            } else {
                outputArea.setText("Max Bet is $100");
            }

            repaint();
        }
        if (e.getSource() == fiveButt) {

            if (curbet != maxbet) {
                curbet = curbet + 5;
                dealButton.setEnabled(true);
            } else {
                outputArea.setText("Max Bet is $100");
            }


            repaint();
        }
        if (e.getSource() == tenButt) {

            if (curbet != maxbet) {
                curbet = curbet + 10;
                dealButton.setEnabled(true);
            } else {
                outputArea.setText("Max Bet is $100");
            }

            repaint();
        }
        if (e.getSource() == twentyButt) {

            if (curbet != maxbet) {
                curbet = curbet + 20;
                dealButton.setEnabled(true);
            } else {
                outputArea.setText("Max Bet is $100");
            }

            repaint();
        }
        if (e.getSource() == fiftyButt) {

            if (curbet != maxbet) {
                curbet = curbet + 50;
                dealButton.setEnabled(true);
            } else {
                outputArea.setText("Max Bet is $100");
            }

            repaint();
        }
        if (e.getSource() == dealButton) {
            if (dubdown == true) {
                curbet = curbet / 2;
                dubdown = false;
            }
            if (curbet != 0) {
                
                disablebetbutts();
                pmoney = pmoney - curbet;
                handsplayed++;
                hitButton.setEnabled(true);
                standButton.setEnabled(true);
                doubledown.setEnabled(true);
                newButton.setEnabled(false);
                dealButton.setEnabled(false);
                
                if (dealerH.getNumcards() > 0) {
                    emptyhands();
                }

                if (theDeck.getNumcards() < 5) {

                    theDeck = new CardList(52);
                    theDeck.shuffle();

                }

                dealerH.insertCard(new Card(theDeck.getFirstCard()));
                theDeck.deleteCard(0);
                dealerH.getFirstCard().setBack(true);

                playerH.insertCard(new Card(theDeck.getFirstCard()));
                theDeck.deleteCard(0);

                dealerH.insertCard(new Card(theDeck.getFirstCard()));
                theDeck.deleteCard(0);

                playerH.insertCard(new Card(theDeck.getFirstCard()));
                theDeck.deleteCard(0);


                if (playerH.getTotal() == 21 & dealerH.getTotal() != 21) {
                    outputArea.setText("Blackjack!!!  You WIN!");
                    hitButton.setEnabled(false);
                    standButton.setEnabled(false);
                    doubledown.setEnabled(false);
                    dealButton.setEnabled(true);
                    dealerH.setbool();
                    bjwin = curbet + (curbet/2);
                    pmoney = pmoney+curbet +(int)bjwin;
                    wincount++;
                    printhands();
                }
                if (playerH.getTotal() == 21 & dealerH.getTotal() == 21) {
                    outputArea.setText("Push with Blackjacks!");
                    hitButton.setEnabled(false);
                    standButton.setEnabled(false);
                    doubledown.setEnabled(false);
                    dealButton.setEnabled(true);
                    dealerH.setbool();
                    pmoney = curbet + pmoney;
                    printhands();
                }

                if (playerH.getTotal() != 21 & dealerH.getTotal() == 21) {
                    outputArea.setText("Dealer Blackjack! You LOSE!");
                    hitButton.setEnabled(false);
                    standButton.setEnabled(false);
                    doubledown.setEnabled(false);
                    dealButton.setEnabled(true);
                    dealerH.setbool();
                    loss++;
                    printhands();

                }
                if (playerH.getTotal() != 21 && dealerH.getTotal() != 21) {
                    outputArea.setText("Player Total: " + playerH.getTotal());
                }
                repaint();
            } else {
                outputArea.setText("Place Bet First");
                enablebetbutts();
            }
        }
            
            if (e.getSource() == newButton) {
                theDeck = new CardList(52);
                theDeck.shuffle();
                enablebetbutts();
                newButton.setEnabled(false);
                dealButton.setEnabled(true);
                pmoney = 1000;
                outputArea.setText("Place Bet(1-100) then Deal cards");

                repaint();
            }
            if (e.getSource() == hitButton) {

                playerH.insertCard(new Card(theDeck.getFirstCard()));
                theDeck.deleteCard(0);
                outputArea.setText("Player card total: " + playerH.getTotal());


                if (playerH.getTotal() > 21) {
                    outputArea.setText("You Busted");
                    hitButton.setEnabled(false);
                    standButton.setEnabled(false);
                    doubledown.setEnabled(false);
                    dealButton.setEnabled(true);
                    dealerH.setbool();
                    loss++;
                    printhands();
                }

                repaint();
            }

            if (e.getSource() == doubledown) {

                playerH.insertCard(new Card(theDeck.getFirstCard()));
                theDeck.deleteCard(0);
                doubledown.setEnabled(false);
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                dealButton.setEnabled(true);
                pmoney = pmoney - curbet;
                curbet = (curbet * 2);
                dubdown = true;

                if (playerH.getTotal() > 21) {
                    outputArea.setText("You Busted");
                    loss++;
                    dealerH.setbool();
                    printhands();
                } else {
                    comparehands();
                    dealerH.setbool();
                }
                NewBet.setEnabled(true);
                repaint();
            }
            if (e.getSource() == standButton) {
                comparehands();
                standButton.setEnabled(false);
                hitButton.setEnabled(false);
                doubledown.setEnabled(false);
                dealButton.setEnabled(true);
                dealerH.setbool();
                NewBet.setEnabled(true);
                repaint();
            }
        }

    public void enablebetbutts() {
        oneButt.setEnabled(true);
        fiveButt.setEnabled(true);
        tenButt.setEnabled(true);
        twentyButt.setEnabled(true);
        fiftyButt.setEnabled(true);
        NewBet.setEnabled(true);
    }

    public void disablebetbutts() {
        oneButt.setEnabled(false);
        fiveButt.setEnabled(false);
        tenButt.setEnabled(false);
        twentyButt.setEnabled(false);
        fiftyButt.setEnabled(false);
        NewBet.setEnabled(false);
    }

    public void emptyhands() {
        while (dealerH.getFirstCard() != null) {
            dealerH.deleteCard(0);
        }

        while (playerH.getFirstCard() != null) {
            playerH.deleteCard(0);
        }
    }

    public void comparehands() {
        while (dealerH.getTotal() < 17) {
            dealerH.insertCard(new Card(theDeck.getFirstCard()));
            theDeck.deleteCard(0);
        }

        if (dealerH.getTotal() > 21 && playerH.getTotal() <= 21) {
            outputArea.setText("Dealer Busted!! You WIN!!");
            pmoney = (curbet * 2) + pmoney;
            wincount++;

        } else if (dealerH.getTotal() == playerH.getTotal()) {
            outputArea.setText("Push!!");
            pmoney = curbet + pmoney;

        } else if (playerH.getTotal() > dealerH.getTotal()) {
            outputArea.setText("You WIN!!");
            pmoney = (curbet * 2) + pmoney;
            wincount++;
        } else {
            outputArea.setText("You Lose!");
            loss++;
        }
        printhands();
    }

    public void printhands() {
        if (loss == 0) {
            textArea.setText("~Stats~\n\n" + "Hands Played: " + (int) handsplayed + "\nWins: " + (int) wincount + "\nLosses: " + (int) loss + "\n\nWin Rate: 100" + "%\n");
        }
        if (wincount == 0) {
            textArea.setText("~Stats~\n\n" + "Hands Played: " + (int) handsplayed + "\nWins: " + (int) wincount + "\nLosses: " + (int) loss + "\n\nWin Rate: 0" + "%\n");
        }
        if (wincount != 0 && loss != 0) {
            textArea.setText("~Stats~\n\n" + "Hands Played: " + (int) handsplayed + "\nWins: " + (int) wincount + "\nLosses: " + (int) loss + "\n\nWin Rate: " + (f.format((wincount / handsplayed) * 100)) + "%\n");
        }
    }

    public static Image load_picture(String fname) {
        Image image;
        MediaTracker tracker = new MediaTracker(myFrame);
        image = myFrame.getToolkit().getImage(fname);
        tracker.addImage(image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        if (tracker.isErrorID(0)) {
            image = null;
        }
        return image;
    }

    class MyPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            g.drawRect(600, 35, 250, 40);
            g.fillRect(600, 35, 250, 40);
            g.setFont(boldfont);
            g.drawString("PLAYER", 230, 500);
            g.drawLine(232, 503, 337, 503);
            g.drawString("DEALER", 230, 200);
            g.drawLine(230, 203, 340, 203);
            g.setFont(regfont);
            g.drawString("$$$: " + pmoney, 240, 530);
            g.drawString("Player Bet: " + curbet, 385, 590);


            int xpos = 375, ypos = 135;
            g.drawRoundRect(xpos-4, ypos-4, 79, 110, 10, 10);
            g.drawRoundRect(xpos+86, ypos-4, 79, 110, 10, 10);
            if (theDeck == null || playerH == null || dealerH == null) {
                return;
            }
            Card current = dealerH.getFirstCard();
            while (current != null) {
                Image tempimage = current.getCardImage();

                if (current.isBack()) {
                    tempimage = cardback.getCardImage();
                    g.drawImage(tempimage, xpos, ypos, this);
                    g.drawRoundRect(xpos-4, ypos-4, 79, 110, 10, 10);
                } else {
                    g.drawImage(tempimage, xpos, ypos, this);
                    g.drawRoundRect(xpos-4, ypos-4, 79, 110, 10, 10);
                }
                xpos += 90;
                current = current.getNextCard();

            }
            ypos = 440;
            xpos = 375;
            g.drawRoundRect(xpos-4, ypos-4, 79, 110, 10, 10);
            g.drawRoundRect(xpos+86, ypos-4, 79, 110, 10, 10);
            current = playerH.getFirstCard();
            while (current != null) {
                Image tempimage = current.getCardImage();
                g.drawImage(tempimage, xpos, ypos, this);
                g.drawRoundRect(xpos-4, ypos-4, 79, 110, 10, 10);
                xpos += 90;
                current = current.getNextCard();

            }
        }
    }
}