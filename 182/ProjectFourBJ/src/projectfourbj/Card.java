package projectfourbj;
import java.awt.Image;

/**
 * @author RobertFlorence Java 182 - Project 4 
 * this project creates a simple
 * blackjack card game, using a linked list data structure 
 * 4-26-13
 */
class Card extends Link {

    private Image cardimage;
    private double cardrank;
    private boolean back = false;

    public void setBack(boolean back) {
        this.back = back;
    }

    public boolean isBack() {
        return back;
    }

    public int getCardrank() {
        return (int)cardrank;
    }

    public Card(int cardnum) {
        cardimage = ProjectFourBJ.load_picture("cards/" + cardnum + ".gif");
        cardrank = Math.ceil((double) cardnum / 4);
        
        if (cardrank > 10) {
            cardrank = 10;
        }
        if (cardrank == 1) {
            cardrank = 11;
        }
        if (cardimage == null) {
            System.out.println("Error - image failed to load: images/card" + cardnum + ".gif");
            System.exit(-1);
        }
    }

    public Card(Card oldcard) {
        cardimage = oldcard.getCardImage();
        cardrank = oldcard.getCardrank();
    }

    public Card getNextCard() {
        return (Card) next;
    }

    public Image getCardImage() {
        return cardimage;
    }
}