
package model;

import java.util.ArrayList;

public class Deck {

    private final ArrayList<Card> cards = new ArrayList();

    public boolean findCardByName(String name) {
        for (Card card : cards) {
            if (card.getName().equals(name))
                return true;
        }

        return false;
    }
    
    /**
     * Adds a new card if its name is not being used.
     * @return true if successfully added, false otherwise
     */
    public boolean addCard(Card card) {
        if (!findCardByName(card.getName())) {
            return cards.add(card);
        } else return false;
    }
    
    public ArrayList<Card> getCards() { return cards; }
}