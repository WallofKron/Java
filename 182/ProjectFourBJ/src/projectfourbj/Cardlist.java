package projectfourbj;

/**
 * @author RobertFlorence Java 182 - Project 4 this project creates a simple
 * card game, blackjack, using a linked list data structures
 * 4-26-13
 */
class CardList {

    private Card firstcard = null;
    private int numcards = 0;

    public CardList(int num) {
        numcards = num;   //set numcards in the deck
        for (int i = 1; i <= num; i++) {  // load the cards
            Card temp = new Card(i);
            if (firstcard != null) {
                temp.setNext(firstcard);
            }
            firstcard = temp;
        }
    }

    public Card getFirstCard() {
        return firstcard;
    }

    public int getNumcards() {
        return numcards;
    }

    public void setbool() {
        Card current = this.getFirstCard();
        while (current != null) {
            current.setBack(false);
            current = current.getNextCard();
        }
    }

    public int getTotal() {
        int total = 0, ace = 0;
        Card current = this.getFirstCard();
        while (current != null) {
            if (current.getCardrank() == 11) {
                ace++;
            }
            total += current.getCardrank();
            while (ace != 0) {
                if (total > 21) {
                    total -= 10;

                    ace--;
                }
            }
                current = current.getNextCard();
        }
        return total;
    }

    public Card deleteCard(int cardnum) {
        Card target, targetprevious;

        if (cardnum > numcards) {
            return null;   // not enough cards to delete that one
        } else {
            numcards--;
        }

        target = firstcard;
        targetprevious = null;
        while (cardnum-- > 0) {
            targetprevious = target;
            target = target.getNextCard();
            if (target == null) {
                return null;  // error, card not found
            }
        }
        if (targetprevious != null) {
            targetprevious.setNext(target.getNextCard());
        } else {
            firstcard = target.getNextCard();
        }
        return target;
    }

    public void insertCard(Card target) {
        numcards++;
        if (firstcard != null) {
            target.setNext(firstcard);
        } else {
            target.setNext(null);
        }
        firstcard = target;
    }

    public void shuffle() {
        for (int i = 0; i < 300; i++) {
            int rand = (int) (Math.random() * 100) % numcards;
            Card temp = deleteCard(rand);
            if (temp != null) {
                insertCard(temp);
            }
        }
    }
}